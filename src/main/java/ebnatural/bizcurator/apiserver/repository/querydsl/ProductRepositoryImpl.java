package ebnatural.bizcurator.apiserver.repository.querydsl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import ebnatural.bizcurator.apiserver.domain.Product;
import ebnatural.bizcurator.apiserver.domain.QProduct;
import ebnatural.bizcurator.apiserver.domain.QProductImage;
import ebnatural.bizcurator.apiserver.dto.request.ProductSearchRequest;
import ebnatural.bizcurator.apiserver.dto.response.ProductResponse;
import ebnatural.bizcurator.apiserver.dto.response.QProductResponse;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import java.util.List;

public class ProductRepositoryImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom {
    public ProductRepositoryImpl() {
        super(Product.class);
    }

    private BooleanExpression productNameLike(String keyWord) {
        return StringUtils.isEmpty(keyWord) ? QProduct.product.name.like("%") : QProduct.product.name.like("%" + keyWord + "%");
    }


    @Override
    public List<ProductResponse> searchByKeyword(ProductSearchRequest productSearchRequest) {
        QProduct product = QProduct.product;
        QProductImage productImage = QProductImage.productImage;

        String keyword = productSearchRequest.getKeyWord();
        JPAQuery<ProductResponse> query = (JPAQuery<ProductResponse>) from(product)
                .leftJoin(productImage).on(product.id.eq(productImage.product.id).and(productImage.repimgYn.eq("Y")))
                .select(new QProductResponse(
                                product.id,
                                product.category.id,
                                product.name,
                                productImage.id,
                                productImage.imgUrl,
                                product.regularPrice,
                                product.discountRate
                        )
                )
                .where(productNameLike(keyword));

        String sort = productSearchRequest.getSort();
        if ("new".equals(sort)) {
            query.orderBy(product.createdAt.desc());
        } else if ("popular".equals(sort)) {
            query.orderBy(product.weeklyClicks.desc());
        } else if ("low_price".equals(sort)) {
            query.orderBy(product.regularPrice.asc());
        } else if ("high_price".equals(sort)) {
            query.orderBy(product.regularPrice.desc());
        }

        return query.fetch();
    }



    @Override
    public List<ProductResponse> findByCategoryId(Long categoryId, String sort) {
        QProduct product = QProduct.product;
        QProductImage productImage = QProductImage.productImage;

        JPAQuery<ProductResponse> query = (JPAQuery<ProductResponse>) from(product)
                .leftJoin(productImage).on(product.id.eq(productImage.product.id).and(productImage.repimgYn.eq("Y")))
                .select(new QProductResponse(
                        product.id,
                        product.category.id,
                        product.name,
                        productImage.id,
                        productImage.imgUrl,
                        product.regularPrice,
                        product.discountRate
                        )
                );

        if (categoryId != null) {
            query.where(product.category.id.eq(categoryId));
        }

        if ("new".equals(sort)) {
            query.orderBy(product.createdAt.desc());
        } else if ("popular".equals(sort)) {
            query.orderBy(product.weeklyClicks.desc());
        } else if ("low_price".equals(sort)) {
            query.orderBy(product.regularPrice.asc());
        } else if ("high_price".equals(sort)) {
            query.orderBy(product.regularPrice.desc());
        }

        return query.fetch();
    }

}
