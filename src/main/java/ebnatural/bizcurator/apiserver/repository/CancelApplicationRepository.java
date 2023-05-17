package ebnatural.bizcurator.apiserver.repository;

import ebnatural.bizcurator.apiserver.domain.CancelApplication;
import ebnatural.bizcurator.apiserver.domain.OrderDetail;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CancelApplicationRepository extends JpaRepository<CancelApplication, Long> {

    boolean existsByOrderDetailId(Long orderId);

    List<CancelApplication> findAllByMemberId(Long memberId);

    List<CancelApplication> findAllByMemberIdAndCreatedAtAfter(Long memberId, LocalDateTime filterDate);

    @Query("SELECT c.orderDetail FROM CancelApplication c WHERE c.id = :id")
    OrderDetail findOrderDetailById(@Param("id") Long id);

    Page<CancelApplication> findAllByOrderByCreatedAtDesc(Pageable pageable);

    @Query("SELECT ca FROM CancelApplication ca JOIN ca.orderDetail od JOIN od.product p WHERE p.name LIKE %:keyword% ORDER BY ca.createdAt DESC")
    Page<CancelApplication> findByOrderDetailProduct_NameContainingOrderByCreatedAtDesc(@Param("keyword") String keyword, Pageable page);

    @Query("SELECT ca.orderDetail, ca.orderDetail.product, ca.orderDetail.product.manufacturer, ca.orderDetail.product.category FROM CancelApplication ca WHERE ca.id = :id")
    Object[] findOrderDetailWithProductAndManufacturerAndCategoryById(@Param("id") Long id);
}