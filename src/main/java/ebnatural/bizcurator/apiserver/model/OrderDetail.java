package ebnatural.bizcurator.apiserver.model;

import ebnatural.bizcurator.apiserver.common.constants.DELIVERY_STATE;
import ebnatural.bizcurator.apiserver.common.constants.ORDER_TYPE;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

@RequiredArgsConstructor
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 고유번호

    private Long paymentId; // 결제 고유 번호

    private int quantity;   // 수량

    // TODO: User 클래스와 join
    //@JoinColumn(name = "buyer_id")
    //@ManyToOne(optional = false, fetch = FetchType.LAZY)
    //private User user;    // 주문자

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;    // 주문시간

    @Column(length = 20)
    private String buyerName;   // 주문자이름

    @Column(length = 20)
    private String buyerPhoneNumber; // 주문자 휴대폰번호

    @Column(length = 100)
    private String address; // 수령주소

    @Column(length = 500)
    private String requestContent; // 요청사항

    @Column(length = 20)
    private String postalCode; // 우편번호

    @Column(length = 10)
    private String paymentMethod; // 결제수단

    private int cost; // 결제금액

    @Column(columnDefinition = "ENUM('PAID', 'DELIVERING', 'DELIVER_DONE', 'FINISH')")
    @Enumerated(EnumType.ORDINAL)
    private DELIVERY_STATE deliveryState; // 배송상태

    @Column(columnDefinition = "ENUM('IMMEDIATE', 'REQUEST_DOCUMENT')")
    @Enumerated(EnumType.ORDINAL)
    private ORDER_TYPE orderType; // 주문 유형

    private int shippingFee; // 배송비

    @Column(length = 20)
    private String invoiceNumber; // 송장번호

}
