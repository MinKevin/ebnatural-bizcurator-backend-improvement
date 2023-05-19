package ebnatural.bizcurator.apiserver.dto;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class CartProductDto {

    private String name; //상품이름
    private double discountPrice;//할인가
    private double regularPrice;//정가
    private int quantity;//수량

    private String productImageDtos;

    public CartProductDto(String name, double discountPrice, double regularPrice, int quantity, String productImageDtos) {
        this.name = name;
        this.discountPrice = discountPrice;
        this.regularPrice = regularPrice;
        this.quantity = quantity;
        this.productImageDtos = productImageDtos;
    }


}
