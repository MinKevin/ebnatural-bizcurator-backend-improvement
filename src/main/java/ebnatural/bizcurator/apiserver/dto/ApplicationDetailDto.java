package ebnatural.bizcurator.apiserver.dto;

import lombok.Getter;

@Getter
public class ApplicationDetailDto {

    private Long paymentId;
    private String image;
    private Long orderId;
    private String orderTime;
    private String name;
    private int quantity;
    private int cost;
    private String state;

    private ApplicationDetailDto(Long paymentId, String image, Long orderId, String orderTime,
            String name, int quantity, int cost, String state) {
        this.paymentId = paymentId;
        this.image = image;
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
        this.state = state;
    }

    public static ApplicationDetailDto of(Long paymentId, String image, Long orderId, String orderTime,
            String name, int quantity, int cost, String state) {
        return new ApplicationDetailDto(paymentId, image, orderId, orderTime, name, quantity, cost, state);
    }

}
