package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.dto.ProductDetailDto;
import ebnatural.bizcurator.apiserver.dto.response.CommonResponse;
import ebnatural.bizcurator.apiserver.dto.ProductListDto;
import ebnatural.bizcurator.apiserver.service.ProductService;
import java.util.HashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        List<ProductListDto> products = productService.getProducts(categoryId, sort);
        HashMap<String, Object> productMap = new HashMap<>();
        productMap.put("products", products);
        return CommonResponse.ok(HttpStatus.OK.value(), "상품 조회가 완료되었습니다.", productMap);
    }

    @GetMapping("/search")
    public ResponseEntity<CommonResponse> searchProducts(
            @RequestParam(required = false) String keyword,//우선 따로 예외처리 하지 않고-keyword를 입력하지않았을 때, 전체 결과를 반환한다. 필요하다면 이 부분 수정.
            @RequestParam(defaultValue = "new") String sort) {
        List<ProductListDto> products = productService.searchProducts(keyword, sort);
        HashMap<String, Object> productMap = new HashMap<>();
        productMap.put("products", products);
        return CommonResponse.ok(HttpStatus.OK.value(), "상품 검색이 완료되었습니다.", productMap);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<CommonResponse> getProductDetail(@PathVariable Long productId) {
        ProductDetailDto productDetail = productService.getProductDetail(productId);
        HashMap<String, Object> productMap = new HashMap<>();
        productMap.put("productDetail", productDetail);
        return CommonResponse.ok(HttpStatus.OK.value(), "상품 상세 정보 조회가 완료되었습니다.", productMap);
    }

    @GetMapping("/top-weekly")
    public ResponseEntity<CommonResponse> getTopWeeklyProducts() {
        List<ProductListDto> products = productService.getTop3ProductsWeekly();
        HashMap<String, Object> productsMap = new HashMap<>();
        productsMap.put("topWeeklyProducts", products);
        return CommonResponse.ok(HttpStatus.OK.value(), "주간 인기 상품 정보 조회가 완료되었습니다.", productsMap);
    }


}
