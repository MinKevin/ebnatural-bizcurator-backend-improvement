package ebnatural.bizcurator.apiserver.repository.querydsl;

import ebnatural.bizcurator.apiserver.dto.request.ProductSearchRequest;
import ebnatural.bizcurator.apiserver.dto.response.ProductResponse;
import java.util.List;

public interface ProductRepositoryCustom {
    List<ProductResponse> findByCategoryId(Long categoryId, String sort);
    List<ProductResponse> searchByKeyword(ProductSearchRequest productSearchRequest);

}
