package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.dto.response.ProductResponse;
import ebnatural.bizcurator.apiserver.repository.ProductRepository;
import ebnatural.bizcurator.apiserver.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(defaultValue = "new") String sort) {
        List<ProductResponse> products = productService.getProducts(categoryId, sort);
        return ResponseEntity.ok(products);
    }
}
