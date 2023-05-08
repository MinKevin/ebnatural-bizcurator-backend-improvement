package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.model.Cart;
import ebnatural.bizcurator.apiserver.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/carts")
@RequiredArgsConstructor
@RestController
public class CartController {
    private final CartService cartService;

    @GetMapping("/")
    public ResponseEntity<ModelMap> getCartsList(ModelMap modelMap){
        List<Cart> cartsList = cartService.getCartsList();
        modelMap.addAttribute(cartsList);
        return ResponseEntity.ok().body(modelMap);
    }

}
