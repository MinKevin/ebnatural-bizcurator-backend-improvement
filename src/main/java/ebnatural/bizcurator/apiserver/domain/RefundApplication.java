package ebnatural.bizcurator.apiserver.domain;

import ebnatural.bizcurator.apiserver.domain.constant.OrderCancelState;
import ebnatural.bizcurator.apiserver.domain.constant.OrderRefundType;
import ebnatural.bizcurator.apiserver.domain.constant.ReceiveWayType;
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
 * 환불신청내역 클래스
 */
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

    @Column(length = 100)
    private String opinionDetail; // 환불 상세 사유

    @Enumerated(EnumType.STRING)
    private OrderRefundType opinionCategory = OrderRefundType.UNSELECTED; // 환불 사유 카테고리

    @Enumerated(EnumType.STRING)
    private OrderCancelState state= OrderCancelState.WAIT; // 상태값

    @Enumerated(EnumType.STRING)
    private ReceiveWayType receiveWayType = ReceiveWayType.PICK_UP_BY_COMPANY;  // 수거신청상태값

    private String address; // 수거지 주소

    @Column(length = 50)
    private String bankAccount; // 환불받을계좌

    private LocalDateTime approveTime; // 처리 완료(FINISHED)된 시간

    @Column(length = 20)
    private String postalCode; // 우편번호
}
