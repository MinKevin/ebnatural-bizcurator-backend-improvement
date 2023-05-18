package ebnatural.bizcurator.apiserver.repository.querydsl;
import ebnatural.bizcurator.apiserver.domain.Category;
import ebnatural.bizcurator.apiserver.domain.Manufacturer;
import ebnatural.bizcurator.apiserver.dto.ProductDetailDto;
import ebnatural.bizcurator.apiserver.dto.ProductListDto;
import java.util.List;

public interface ProductRepositoryCustom {
    List<ProductListDto> findByCategoryId(Long categoryId, String sort);
    List<ProductListDto> searchByKeyword(String keyword, String sort);
    ProductDetailDto findDetailById(Long productId);
    List<ProductListDto> findTop3ByWeeklyClicks();
    List<ProductListDto> findTop3ByMonthlyClicks();

}
