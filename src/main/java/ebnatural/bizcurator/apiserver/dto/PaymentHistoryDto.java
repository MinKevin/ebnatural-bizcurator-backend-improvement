package ebnatural.bizcurator.apiserver.dto;

import ebnatural.bizcurator.apiserver.domain.constant.DeliveryState;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;

@Getter
public class PaymentHistoryDto {
    private Long paymentId;

    private List<OrderHistoryDto> orderInfo;

    @Getter
    public static class OrderHistoryDto {
        private Long orderId;
        private String image;
        private DeliveryState deliveryState;
        private LocalDateTime orderTime;
        private String name;
        private int quantity;
        private int cost;

        public OrderHistoryDto(Long orderId, String image, DeliveryState deliveryState,
                LocalDateTime orderTime, String name, int quantity, int cost) {
            this.orderId = orderId;
            this.image = image;
            this.deliveryState = deliveryState;
            this.orderTime = orderTime;
            this.name = name;
            this.quantity = quantity;
            this.cost = cost;
        }


        public static OrderHistoryDto of(Long orderId, String image, DeliveryState deliveryState,
                LocalDateTime orderTime, String name, int quantity, int cost) {
            return new OrderHistoryDto(orderId, image, deliveryState, orderTime, name, quantity,
                    cost);
        }
    }

    private PaymentHistoryDto(Long paymentId, List<OrderHistoryDto> orderInfo) {
        this.paymentId = paymentId;
        this.orderInfo = orderInfo;
    }

    public static PaymentHistoryDto of(Long paymentId, List<OrderHistoryDto> orderInfo) {
        return new PaymentHistoryDto(paymentId, orderInfo);
    }
}
