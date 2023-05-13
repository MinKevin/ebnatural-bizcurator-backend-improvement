package ebnatural.bizcurator.apiserver.repository.querydsl;

import com.querydsl.core.types.EntityPath;
import com.querydsl.jpa.impl.JPAQuery;
import ebnatural.bizcurator.apiserver.domain.Product;
import ebnatural.bizcurator.apiserver.dto.response.ProductResponse;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class ProductRepositoryImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom {
    public ProductRepositoryImpl() {
        super(Product.class);
    }

    @Override
    public List<ProductResponse> findByCategoryId(Long categoryId, String sort) {
        QProduct product = QProduct.product;
        QProductImage productImage = QProductImage.productImage;

        JPAQuery<ProductResponse> query = from(product)
                .leftJoin((EntityPath) productImage).on(product.id.eq(productImage.product.id).and(productImage.repimgYn.eq("Y")))
                .select(new QProductResponse(
                        product.id,
                        product.category.id,
                        product.name,
                        productImage.id,
                        productImage.image_url,
                        product.regular_price,
                        product.discount_rate,
                        product.regular_price.subtract(
                                product.regular_price.multiply(product.discount_rate).divide(100)
                        )
                ));

        if (categoryId != null) {
            query.where(product.category.id.eq(categoryId));
        }

        if ("new".equals(sort)) {
            query.orderBy(product.created_at.desc());
        } else if ("popular".equals(sort)) {
            query.orderBy(product.weekly_clicks.desc());
        } else if ("low_price".equals(sort)) {
            query.orderBy(product.regular_price.asc());
        } else if ("high_price".equals(sort)) {
            query.orderBy(product.regular_price.desc());
        }

        return query.fetch();
    }

}
