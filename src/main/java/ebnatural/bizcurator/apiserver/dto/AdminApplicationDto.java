package ebnatural.bizcurator.apiserver.dto;

import lombok.Getter;

/**
 * 관리자페이지
 * 주문 취소, 환불 신청 내역 dto
 */
@Getter
public class AdminApplicationDto {
    private Long applicationId;
    private String productName;
    private String manufacturerName;
    private String productCategory;
    private String orderTime;
    private String state;
    private int quantity;
    private int cost;
    private String opinionCategory;

    private AdminApplicationDto(Long applicationId, String productName, String manufacturerName,
            String productCategory, String orderTime, String state, int quantity, int cost, String opinionCategory) {
        this.applicationId = applicationId;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.productCategory = productCategory;
        this.orderTime = orderTime;
        this.state = state;
        this.quantity = quantity;
        this.cost = cost;
        this.opinionCategory = opinionCategory;
    }

    public static AdminApplicationDto of(Long applicationId, String productName, String manufacturerName,
            String productCategory, String orderTime, String deliveryState, int quantity, int cost, String opinionCategory) {
        return new AdminApplicationDto(applicationId, productName, manufacturerName, productCategory, orderTime, deliveryState, quantity, cost, opinionCategory);
    }
}
