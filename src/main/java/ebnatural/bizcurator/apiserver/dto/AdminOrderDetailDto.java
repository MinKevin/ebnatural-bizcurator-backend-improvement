package ebnatural.bizcurator.apiserver.dto;

import lombok.Getter;

@Getter
public class AdminOrderDetailDto {

    private Long orderId;
    private String productName;
    private String manufacturerName;
    private String productCategory;
    private String deliveryTime;
    private String deliveryState;
    private int quantity;
    private int cost;
    private String invoiceNumber;

    private AdminOrderDetailDto(Long orderId, String productName, String manufacturerName,
            String productCategory, String deliveryTime, String deliveryState, int quantity,
            int cost,
            String invoiceNumber) {
        this.orderId = orderId;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.productCategory = productCategory;
        this.deliveryTime = deliveryTime;
        this.deliveryState = deliveryState;
        this.quantity = quantity;
        this.cost = cost;
        this.invoiceNumber = invoiceNumber;
    }

    public static AdminOrderDetailDto of(Long orderId, String productName, String manufacturerName,
            String productCategory, String deliveryTime, String deliveryState, int quantity, int cost, String invoiceNumber) {

        return new AdminOrderDetailDto(orderId, productName, manufacturerName, productCategory, deliveryTime, deliveryState, quantity, cost, invoiceNumber);
    }
}
