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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * 구매취소신청내역 클래스
 */

@Entity
public class CancelApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 고유번호

    @JoinColumn(name = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Member member;    // 주문자

    @JoinColumn(name = "order_id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private OrderDetail orderDetail;    // 주문정보

    @Enumerated(EnumType.STRING)
    private OrderCancelType opinionCategory = OrderCancelType.UNSELECTED; // 취소 사유 카테고리

    @Enumerated(EnumType.STRING)
    private OrderCancelState state = OrderCancelState.WAIT; // 상태값

    private LocalDateTime approveTime; // 처리 완료(FINISHED)된 시간

    private CancelApplication() {

    }

    private CancelApplication(Member member, OrderDetail orderDetail,
            OrderCancelType opinionCategory) {
        this.member = member;
        this.orderDetail = orderDetail;
        this.opinionCategory = opinionCategory;
    }
    public static CancelApplication of(Member member, OrderDetail orderDetail,
            OrderCancelType opinionCategory) {
        return new CancelApplication(member, orderDetail, opinionCategory);
    }
}
