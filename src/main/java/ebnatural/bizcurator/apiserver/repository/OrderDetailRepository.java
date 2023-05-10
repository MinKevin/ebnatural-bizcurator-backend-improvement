package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

}
