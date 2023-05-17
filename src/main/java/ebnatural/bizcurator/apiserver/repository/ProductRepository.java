package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.Product;
import ebnatural.bizcurator.apiserver.repository.querydsl.ProductRepositoryCustom;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

    @Modifying
    @Query("update Product p set p.weeklyClicks = 0")
    void resetWeeklyClicks();

    @Modifying
    @Query("update Product p set p.monthlyClicks = 0")
    void resetMonthlyClicks();
}
