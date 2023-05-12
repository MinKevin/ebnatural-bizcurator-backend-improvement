package ebnatural.bizcurator.apiserver.controller;

<<<<<<< HEAD
import ebnatural.bizcurator.apiserver.domain.Cart;
import ebnatural.bizcurator.apiserver.dto.request.CartProductRequest;
import ebnatural.bizcurator.apiserver.dto.response.CartProductResponse;
import ebnatural.bizcurator.apiserver.service.CartService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
=======
import ebnatural.bizcurator.apiserver.model.Cart;
import ebnatural.bizcurator.apiserver.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> origin/feature/#1-cart

import java.util.List;

@RequestMapping("/api/carts")
@RequiredArgsConstructor
@RestController
public class CartController {
    private final CartService cartService;

<<<<<<< HEAD
    public static final String CONTAINING_SUCCESS = "장바구니담기 성공";
    public static final String UPDATE_SUCCESS = "상품 수정 성공";
    @GetMapping("/")//장바구니 조회
    public ResponseEntity<ModelMap> getCartsList(ModelMap modelMap) {
        List<CartProductResponse> cartsList = cartService.getCartsList();
        modelMap.addAttribute("cartProducts",cartsList);
        return ResponseEntity.ok().body(modelMap);
    }

    //장바구니 담기
    @PostMapping("/")
    public HttpEntity<String> containingProduct(@RequestBody CartProductRequest productRequest){
        cartService.containingCartProducts(productRequest);
        return ResponseEntity.ok(CONTAINING_SUCCESS);
    }

    //장바구니 상품 수량 수정
    @PatchMapping("/")
    public HttpEntity<String> updateProductQuantity(@RequestBody CartProductRequest productRequest){

        //cartService.updateProductQuantity(productRequest);
        return ResponseEntity.ok(UPDATE_SUCCESS);
    }

    //장바구니 상품 삭제
=======
    @GetMapping("/")
    public ResponseEntity<ModelMap> getCartsList(ModelMap modelMap){
        List<Cart> cartsList = cartService.getCartsList();
        modelMap.addAttribute(cartsList);
        return ResponseEntity.ok().body(modelMap);
    }

>>>>>>> origin/feature/#1-cart
}
