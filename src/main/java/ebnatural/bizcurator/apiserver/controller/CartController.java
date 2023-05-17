package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.dto.CartProductDto;
import ebnatural.bizcurator.apiserver.dto.request.CartProductRequest;
import ebnatural.bizcurator.apiserver.dto.response.CommonResponse;
import ebnatural.bizcurator.apiserver.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CartController {
    private final CartService cartService;

    public static final String CONTAINING_SUCCESS = "장바구니담기 성공";
    public static final String UPDATE_SUCCESS = "상품 수정 성공";

    @GetMapping("/api/carts")//장바구니 조회
    public ResponseEntity<CommonResponse> getCartsList() {
        List<CartProductDto> cartLists = cartService.getCartsList();
        HashMap<String, Object> cartMap = new HashMap<>();
        cartMap.put("cartsLists", cartLists);
        return CommonResponse.ok(HttpStatus.OK.value(), "장바구니 조회가 완료되었습니다. ", cartMap);
    }

    //장바구니 담기
    @PostMapping("/api/carts/add")
    public ResponseEntity<CommonResponse> containingProduct(@RequestBody CartProductRequest productRequest) {
        cartService.containingCartProducts(productRequest);
        return CommonResponse.ok(HttpStatus.OK.value(), CONTAINING_SUCCESS);
    }

    //장바구니 상품 수량 수정
    @PatchMapping("/api/carts/update")
    public ResponseEntity<CommonResponse> updateProductQuantity(@RequestBody CartProductRequest productRequest) {

        cartService.updateProductQuantity(productRequest);
        return CommonResponse.ok(HttpStatus.OK.value(), CONTAINING_SUCCESS);
    }

    //장바구니 상품 삭제
    @PostMapping("/api/carts/delete/{product_id}")
    public ResponseEntity<CommonResponse> deleteCartsList(@PathVariable("product_id") Long productId) {
        cartService.deleteProductsByCart(productId);
        List<CartProductDto> cartsList = cartService.getCartsList();
        HashMap<String, Object> cartMap = new HashMap<>();
        cartMap.put("cartProducts", cartsList);
        return CommonResponse.ok(HttpStatus.OK.value(), "장바구니 조회가 완료되었습니다. ", cartMap);
    }

}
