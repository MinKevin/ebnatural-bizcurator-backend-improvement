package ebnatural.bizcurator.apiserver.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import ebnatural.bizcurator.apiserver.domain.ProductImage;

public class ProductResponse {
    private Long id;
    private Long categoryId;
    private String name;
    private ProductImage mainImage;
    private int regularPrice;
    private int discountRate;
    private int salePrice;

    @QueryProjection
    public ProductResponse(Long id, Long categoryId, String name, ProductImage mainImage, int regularPrice, int discountRate) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.mainImage = mainImage;
        this.regularPrice = regularPrice;
        this.discountRate = discountRate;
        this.salePrice = regularPrice * (100 - discountRate) / 100;
    }

}
