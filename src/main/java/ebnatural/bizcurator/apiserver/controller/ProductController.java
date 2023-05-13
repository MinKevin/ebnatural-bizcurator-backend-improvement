package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.dto.response.ProductResponse;
import ebnatural.bizcurator.apiserver.repository.ProductRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(defaultValue = "new") String sort) {
        List<ProductResponse> products = productRepository.findByCategoryId(categoryId, sort);
        return ResponseEntity.ok(products);
    }
}
