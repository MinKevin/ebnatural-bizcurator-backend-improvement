package ebnatural.bizcurator.apiserver.dto;

import ebnatural.bizcurator.apiserver.domain.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class CartProductDto {

    private String name; //상품이름
    private double discountPrice;//할인가
    private double regularPrice;//정가
    private int quantity;//수량
    private List<ProductImage> productImage;



}
