package ebnatural.bizcurator.apiserver.service;

import ebnatural.bizcurator.apiserver.common.exception.custom.CategoryNotFoundException;
import ebnatural.bizcurator.apiserver.common.exception.custom.ProductNotFoundException;
import ebnatural.bizcurator.apiserver.domain.ProductImage;
import ebnatural.bizcurator.apiserver.dto.ProductListDto;
import ebnatural.bizcurator.apiserver.repository.CategoryRepository;
import ebnatural.bizcurator.apiserver.repository.ProductImageRepository;
import ebnatural.bizcurator.apiserver.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;  // CategoryRepository 인스턴스 추가
    private final ProductImageRepository productImageRepository;

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

    /**
     * 물품의 이미지들을 반환한다.
     * @param productId
     * @return
     */
    public List<ProductImage> getProductImages(Long productId) {
        List<ProductImage> productImages = productImageRepository.findAllByProductId(productId);
        if(productImages.isEmpty()){
            return null;
        }

        return productImages;
    }

    /**
     * 물품의 메인 이미지를 반환한다.
     * 메인이미지는 0번째 이미지라고 한다.
     * @param productId
     * @return
     */
    public ProductImage getProductMainImage(Long productId) {
        List<ProductImage> productImages = this.getProductImages(productId);
        if(productImages.isEmpty()){
            return null;
        }

        return productImages.get(0);
    }
}
