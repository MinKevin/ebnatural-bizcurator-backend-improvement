package ebnatural.bizcurator.apiserver.dto.response;

import ebnatural.bizcurator.apiserver.domain.ProductImage;
import lombok.*;

@AllArgsConstructor
@Builder
public class CartProductResponse {

    private String name; //상품이름
    private double discountPrice;//할인가
    private double regularPrice;//정가
    private int quantity;//수량
    private ProductImage productImage;


    public String getProductImage() {

        return productImage.getImgUrl();
    }
}
