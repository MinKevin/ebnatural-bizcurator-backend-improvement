package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.Product;
import ebnatural.bizcurator.apiserver.repository.querydsl.ProductRepositoryCustom;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

    public Optional<Product> findById(Long id);
    @Query("SELECT p.manufacturer, p.category FROM Product p WHERE p.id = :id")
    Optional<Object[]> findManufacturerAndCategoryById(@Param("id") Long id);
}
