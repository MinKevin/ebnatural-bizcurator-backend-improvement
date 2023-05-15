package ebnatural.bizcurator.apiserver.service;

import ebnatural.bizcurator.apiserver.common.exception.custom.CategoryNotFoundException;
import ebnatural.bizcurator.apiserver.common.exception.custom.ProductNotFoundException;
import ebnatural.bizcurator.apiserver.dto.ProductListDto;
import ebnatural.bizcurator.apiserver.repository.CategoryRepository;
import ebnatural.bizcurator.apiserver.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;  // CategoryRepository 인스턴스 추가

    public List<ProductListDto> getProducts(Long categoryId, String sort) {
        if (categoryId != null && !categoryRepository.existsById(categoryId)) {  // 인스턴스를 사용하여 existsById 메소드 호출 및 categoryId가 존재할 때만
            throw new CategoryNotFoundException();
        }return productRepository.findByCategoryId(categoryId, sort);
    }
    public List<ProductListDto> searchProducts(String keyword, String sort) {
        List<ProductListDto> products = productRepository.searchByKeyword(keyword, sort);

        if (products.isEmpty()) {
            throw new ProductNotFoundException();
        }

        return products;
    }
}
