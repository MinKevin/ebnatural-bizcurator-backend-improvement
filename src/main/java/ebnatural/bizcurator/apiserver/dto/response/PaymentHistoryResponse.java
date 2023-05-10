package ebnatural.bizcurator.apiserver.dto.response;

import java.util.List;

public class PaymentHistoryResponse {

    private int paymentId;

    private List<OrderHistoryResponse> orderInfo;

    public static class OrderHistoryResponse {
        private int orderId;
        private String image;
        private int deliveryState;
        private String orderTime;
        private String name;
        private int quantity;
        private int amount;
    }

}
