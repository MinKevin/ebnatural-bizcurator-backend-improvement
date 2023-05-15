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
@RequestMapping("/products")
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
            @RequestParam(required = false) String keyword,//우선 따로 예외처리 하지 않고-keyword를 입력하지않았을 때, 전체 결과를 반환한다. 필요하다면 이 부분 수정.
            @RequestParam(defaultValue = "new") String sort) {
        List<ProductResponse> products = productService.searchProducts(keyword, sort);
        HashMap<String, Object> productMap = new HashMap<>();
        productMap.put("products", products);
        return CommonResponse.ok(HttpStatus.OK.value(), "상품 검색이 완료되었습니다.", productMap);
    }
}
