package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}
