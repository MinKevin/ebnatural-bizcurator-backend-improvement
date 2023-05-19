package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.dto.CartProductDto;
import ebnatural.bizcurator.apiserver.dto.request.CartProductRequest;
import ebnatural.bizcurator.apiserver.dto.response.CommonResponse;
import ebnatural.bizcurator.apiserver.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CartController {

  private final CartService cartService;


    @GetMapping("/api/carts")//장바구니 조회
    public ResponseEntity<CommonResponse> getCartsList() {
        List<CartProductDto> cartLists = cartService.getCartsList();
        HashMap<String, Object> cartMap = new HashMap<>();
        cartMap.put("cartsLists", cartLists);
        return CommonResponse.ok(HttpStatus.OK.value(), "장바구니 조회가 완료되었습니다. ", cartMap);
    }

    //장바구니 담기
    @PostMapping("/api/carts/add")
    public ResponseEntity<CommonResponse> containingProduct(@Valid @RequestBody CartProductRequest productRequest) {
        cartService.containingCartProducts(productRequest);
        return CommonResponse.ok(HttpStatus.OK.value(), "장바구니담기 성공");
    }

    //장바구니 상품 수량 수정
//    @PatchMapping("/api/carts/{D}")
//    public ResponseEntity<CommonResponse> updateProductQuantity(@PathVariable("cartId")Long cartId,@RequestParam int quantity) {
//
//        cartService.updateProductQuantity(cartId,quantity);
//        return CommonResponse.ok(HttpStatus.OK.value(), "상품수량 수정 성공");
//    }

    //장바구니 상품 삭제
    @PostMapping("/api/carts/delete")
    public ResponseEntity<CommonResponse> deleteCartsList(@RequestBody Long productId) {
        cartService.deleteProductsByCart(productId);
        List<CartProductDto> cartsList = cartService.getCartsList();
        HashMap<String, Object> cartMap = new HashMap<>();
        cartMap.put("cartProducts", cartsList);
        return CommonResponse.ok(HttpStatus.OK.value(), "장바구니 삭제가 완료되었습니다. ", cartMap);
    }

}
