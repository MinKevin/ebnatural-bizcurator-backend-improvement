package ebnatural.bizcurator.apiserver.repository.querydsl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import ebnatural.bizcurator.apiserver.domain.Product;
import ebnatural.bizcurator.apiserver.domain.QProduct;
import ebnatural.bizcurator.apiserver.domain.QProductImage;
import ebnatural.bizcurator.apiserver.dto.ProductDetailDto;
import ebnatural.bizcurator.apiserver.dto.ProductListDto;
import ebnatural.bizcurator.apiserver.dto.QProductDetailDto;
import ebnatural.bizcurator.apiserver.dto.QProductListDto;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import java.util.List;

public class ProductRepositoryImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom {
    public ProductRepositoryImpl() {
        super(Product.class);
    }

    private BooleanExpression productNameLike(String keyword) {
        return StringUtils.isEmpty(keyword) ? QProduct.product.name.like("%") : QProduct.product.name.like("%" + keyword + "%");
    }


    @Override
    public List<ProductListDto> searchByKeyword(String keyword, String sort) {
        QProduct product = QProduct.product;
        QProductImage productImage = QProductImage.productImage;

        JPAQuery<ProductListDto> query = (JPAQuery<ProductListDto>) from(product)
                .leftJoin(productImage).on(product.id.eq(productImage.product.id).and(productImage.repimgYn.eq("Y")))
                .select(new QProductListDto(
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
    public List<ProductListDto> findByCategoryId(Long categoryId, String sort) {
        QProduct product = QProduct.product;
        QProductImage productImage = QProductImage.productImage;

        JPAQuery<ProductListDto> query = (JPAQuery<ProductListDto>) from(product)
                .leftJoin(productImage).on(product.id.eq(productImage.product.id).and(productImage.repimgYn.eq("Y")))
                .select(new QProductListDto(
                        product.id,
                        product.category.id,
                        product.name,
                        productImage.id,
                        productImage.imgUrl,
                        product.regularPrice,
                        product.discountRate
                        )
                );
        // categoryId가 null이 아닐 때만 where 절에 categoryId 조건을 추가합니다.
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

    @Override
    public ProductDetailDto findDetailById(Long productId) {
        QProduct product = QProduct.product;
        QProductImage productImage = QProductImage.productImage;
        QProductImage detailImage = new QProductImage("detailImage");

        JPAQuery<ProductDetailDto> query = (JPAQuery<ProductDetailDto>) from(product)
                .leftJoin(productImage).on(product.id.eq(productImage.product.id).and(productImage.repimgYn.eq("Y")))
                .leftJoin(detailImage).on(product.id.eq(detailImage.product.id).and(detailImage.repimgYn.eq("N")))
                .select(new QProductDetailDto(
                        product.id,
                        product.category.id,
                        product.name,
                        productImage.id,
                        productImage.imgUrl,
                        detailImage.id,
                        detailImage.imgUrl,
                        product.regularPrice,
                        product.discountRate,
                        product.minQuantity
                ))
                .where(product.id.eq(productId));

        return query.fetchOne();
    }


}
