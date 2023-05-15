package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.OrderDetail;
import ebnatural.bizcurator.apiserver.domain.Product;
import ebnatural.bizcurator.apiserver.domain.constant.DeliveryState;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    List<OrderDetail> findAllByMemberIdAndOrderTimeAfterAndDeliveryState(Long memberId, LocalDateTime orderTime, DeliveryState deliveryState);

    List<OrderDetail> findAllByMemberIdAndOrderTimeAfter(Long memberId, LocalDateTime orderTime);

    List<OrderDetail> findAllByMemberIdAndDeliveryState(Long memberId, DeliveryState deliveryState);

    List<OrderDetail> findAllByMemberId(Long memberId);

    List<OrderDetail> findAllByPaymentIdAndMemberId(Long paymentId, Long memberId);

    Optional<OrderDetail> findById(Long id);

}
