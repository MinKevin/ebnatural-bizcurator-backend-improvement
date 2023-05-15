package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.CancelApplication;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancelApplicationRepository extends JpaRepository<CancelApplication, Long> {

    boolean existsByOrderDetailId(Long orderId);

    List<CancelApplication> findAllByMemberId(Long memberId);

    List<CancelApplication> findAllByMemberIdAndCreatedAtAfter(Long memberId, LocalDateTime filterDate);
}