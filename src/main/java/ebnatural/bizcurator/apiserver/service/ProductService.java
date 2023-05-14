package ebnatural.bizcurator.apiserver.service;

import ebnatural.bizcurator.apiserver.dto.request.ProductSearchRequest;
import ebnatural.bizcurator.apiserver.dto.response.ProductResponse;
import ebnatural.bizcurator.apiserver.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductResponse> getProducts(Long categoryId, String sort) {
        return productRepository.findByCategoryId(categoryId, sort);
    }

    public List<ProductResponse> searchProducts(ProductSearchRequest productSearchRequest) {
        return productRepository.searchByKeyword(productSearchRequest);
    }
}
