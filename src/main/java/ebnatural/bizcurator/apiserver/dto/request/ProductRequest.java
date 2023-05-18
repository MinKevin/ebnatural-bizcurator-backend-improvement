package ebnatural.bizcurator.apiserver.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import ebnatural.bizcurator.apiserver.domain.Category;
import ebnatural.bizcurator.apiserver.domain.Manufacturer;
import ebnatural.bizcurator.apiserver.domain.Product;
import java.util.ArrayList;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class ProductRequest {

        @JsonProperty("category_id")
        private Long categoryId;

        @JsonProperty("manufacturer_name")
        private String manufacturerName;

        @Length(max = 50, message = "최대 50글자")
        @NotBlank(message = "상품명은 필수 입력값입니다.")
        @JsonProperty("product_name")
        private String name;

        @JsonProperty("regular_price")
        private int regularPrice;

        @JsonProperty("min_quantity")
        private int minQuantity;

        @JsonProperty("max_quantity")
        private int maxQuantity;

        @JsonProperty("discount_rate")
        private int discountRate;


        public ProductRequest() {
        }

    public ProductRequest(Long categoryId, String manufacturerName, String name, int regularPrice, int minQuantity, int maxQuantity, int discountRate) {
        this.categoryId = categoryId;
        this.manufacturerName = manufacturerName;
        this.name = name;
        this.regularPrice = regularPrice;
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
        this.discountRate = discountRate;
    }

    public Product toEntity(Category category, Manufacturer manufacturer){
        return Product.builder()
                .category(category)
                .manufacturer(manufacturer)
                .name(name)
                .regularPrice(regularPrice)
                .minQuantity(minQuantity)
                .maxQuantity(maxQuantity)
                .discountRate(discountRate)
                .productImages(new ArrayList<>())
                .weeklyClicks(0)
                .monthlyClicks(0)
                .build();
    }

}
