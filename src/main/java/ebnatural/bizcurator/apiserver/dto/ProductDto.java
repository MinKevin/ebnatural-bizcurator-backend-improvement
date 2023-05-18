package ebnatural.bizcurator.apiserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ebnatural.bizcurator.apiserver.domain.Category;
import ebnatural.bizcurator.apiserver.domain.Manufacturer;
import ebnatural.bizcurator.apiserver.domain.Product;
import ebnatural.bizcurator.apiserver.domain.ProductImage;
import ebnatural.bizcurator.apiserver.repository.querydsl.ProductRepositoryCustom;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

public class ProductDto {
    private Long id;
    @JsonProperty("category_id")
    private Long categoryId;
    @JsonProperty("manufacturer_name")
    private String manufacturerName;
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

    @JsonProperty("main_image_id")
    private Long mainImageId;
    @Getter
    @Setter
    @JsonProperty("main_image_url")
    private String mainImageUrl;
    @JsonProperty("detail_image_id")
    private Long detailImageId;
    @Getter
    @Setter
    @JsonProperty("detail_image_url")
    private String detailImageUrl;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.categoryId = product.getCategory().getId();
        this.manufacturerName = product.getManufacturer().getName();
        this.name = product.getName();
        this.regularPrice = product.getRegularPrice();
        this.minQuantity = product.getMinQuantity();
        this.maxQuantity = product.getMaxQuantity();
        this.discountRate = product.getDiscountRate();
    }


    public Product toEntity(ProductRepositoryCustom productRepositoryCustom) {
        Product product = new Product();
        product.setName(this.name);
        product.setRegularPrice(this.regularPrice);
        product.setMinQuantity(this.minQuantity);
        product.setMaxQuantity(this.maxQuantity);
        product.setDiscountRate(this.discountRate);

        // Get or create manufacturer by its name
        Manufacturer manufacturer = productRepositoryCustom.findOrCreateManufacturer(this.manufacturerName);

        // Find category by its ID using ProductRepositoryCustom
        Category category = productRepositoryCustom.findCategoryById(this.categoryId);


        product.setCategory(category);
        product.setManufacturer(manufacturer);
        product.setProductImages(new ArrayList<>());

        return product;
    }

}
