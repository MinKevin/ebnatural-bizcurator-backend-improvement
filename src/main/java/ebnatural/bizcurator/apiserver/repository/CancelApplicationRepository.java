package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.CancelApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancelApplicationRepository extends JpaRepository<CancelApplication, Long> {

    boolean existsByOrderDetailId(Long orderId);
}