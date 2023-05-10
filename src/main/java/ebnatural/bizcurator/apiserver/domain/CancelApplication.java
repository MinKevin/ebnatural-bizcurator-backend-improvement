package ebnatural.bizcurator.apiserver.domain;

import ebnatural.bizcurator.apiserver.domain.constant.OrderCancelState;
import ebnatural.bizcurator.apiserver.domain.constant.OrderCancelType;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 구매취소신청내역 클래스
 */
@Entity
public class CancelApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 고유번호

    // TODO: User 클래스와 join
    //@JoinColumn(name = "user_id")
    //@ManyToOne(optional = false, fetch = FetchType.LAZY)
    //private User user;    // 주문자

    @JoinColumn(name = "order_id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private OrderDetail orderDetail;    // 주문정보

    @Column(length = 100)
    private String opinionDetail; // 취소 사유

    @Column(columnDefinition = "ENUM('UNSELECTED', 'CHANGE_OF_MIND', 'UNSATISFIED', 'DELIVERY_DELAYED')")
    @Enumerated(EnumType.ORDINAL)
    private OrderCancelType opinionCategory = OrderCancelType.UNSELECTED; // 취소 사유 카테고리

    @Column(columnDefinition = "ENUM('WAIT', 'APPROVE', 'REJECTED', 'FINISHED')")
    @Enumerated(EnumType.ORDINAL)
    private OrderCancelState state= OrderCancelState.WAIT; // 상태값

    private LocalDateTime approveTime; // 처리 완료(FINISHED)된 시간
}
