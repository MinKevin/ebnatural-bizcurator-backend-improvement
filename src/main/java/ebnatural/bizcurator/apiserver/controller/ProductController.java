package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.dto.request.ProductSearchRequest;
import ebnatural.bizcurator.apiserver.dto.response.CommonResponse;
import ebnatural.bizcurator.apiserver.dto.response.ProductResponse;
import ebnatural.bizcurator.apiserver.service.ProductService;
import java.util.HashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<CommonResponse> getProducts(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(defaultValue = "new") String sort) {
        List<ProductResponse> products = productService.getProducts(categoryId, sort);
        HashMap<String, Object> productMap = new HashMap<>();
        productMap.put("products", products);
        return CommonResponse.ok(HttpStatus.OK.value(), "상품 조회가 완료되었습니다.", productMap);
    }

    @GetMapping("/search")
    public ResponseEntity<CommonResponse> searchProducts(
            ProductSearchRequest productSearchRequest) {
        List<ProductResponse> products = productService.searchProducts(productSearchRequest);
        HashMap<String, Object> productMap = new HashMap<>();
        if (products.isEmpty()) {
            return CommonResponse.ok(HttpStatus.NOT_FOUND.value(), "해당 상품을 찾을 수 없습니다.", productMap);
        }
        productMap.put("products", products);
        return CommonResponse.ok(HttpStatus.OK.value(), "상품 검색이 완료되었습니다.", productMap);
    }
}
