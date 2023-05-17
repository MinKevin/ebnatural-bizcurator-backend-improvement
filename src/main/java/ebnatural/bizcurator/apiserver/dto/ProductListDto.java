package ebnatural.bizcurator.apiserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class ProductListDto {
    private Long id;

    @JsonProperty("category_id")
    private Long categoryId;

    private String name;

    @JsonProperty("main_image_id")
    private Long mainImageId;

    @JsonProperty("main_image_url")
    private String mainImageUrl;

    @JsonProperty("regular_price")
    private int regularPrice;

    @JsonProperty("discount_rate")
    private int discountRate;

    @JsonProperty("sale_price")
    private int salePrice;

    @QueryProjection
    public ProductListDto(Long id, Long categoryId, String name, Long mainImageId, String mainImageUrl, int regularPrice, int discountRate) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.mainImageId = mainImageId;
        this.mainImageUrl = mainImageUrl;
        this.regularPrice = regularPrice;
        this.discountRate = discountRate;
        this.salePrice = regularPrice * (100 - discountRate) / 100;
    }

}
