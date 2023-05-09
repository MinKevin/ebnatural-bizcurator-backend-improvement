package ebnatural.bizcurator.apiserver.model;

import ebnatural.bizcurator.apiserver.common.constants.OrderCancelState;
import ebnatural.bizcurator.apiserver.common.constants.OrderRefundType;
import ebnatural.bizcurator.apiserver.common.constants.ReceiveWayType;
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

@Entity
public class RefundApplication {
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

    private String opinionDetail; // 환불 상세 사유

    @Column(columnDefinition = "ENUM('UNSELECTED', 'CHANGE_OF_MIND', 'UNSATISFIED', 'DEFECT', 'SHIPPING_ERROR')")
    @Enumerated(EnumType.ORDINAL)
    private OrderRefundType opinionCategory = OrderRefundType.UNSELECTED; // 환불 사유 카테고리

    @Column(columnDefinition = "ENUM('WAIT', 'APPROVE', 'REJECTED', 'FINISHED')")
    @Enumerated(EnumType.ORDINAL)
    private OrderCancelState state= OrderCancelState.WAIT; // 상태값

    @Column(columnDefinition = "ENUM('PICK_UP_BY_COMPANY', 'SEND_BY_USER')")
    @Enumerated(EnumType.ORDINAL)
    private ReceiveWayType receiveWayType = ReceiveWayType.PICK_UP_BY_COMPANY;  // 수거신청상태값

    private String address; // 수거지 주소

    private String bankAccount; // 환불받을계좌

    private LocalDateTime approveTime; // 처리 완료(FINISHED)된 시간

    private String postalCode; // 우편번호
}
