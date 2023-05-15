package ebnatural.bizcurator.apiserver.dto;

import ebnatural.bizcurator.apiserver.domain.OrderDetail;
import ebnatural.bizcurator.apiserver.domain.constant.DeliveryState;
import ebnatural.bizcurator.apiserver.dto.PaymentHistoryDto.OrderHistoryDto;
import java.time.LocalDateTime;

public class OrderDetailDto {
    private Long orderId;
    private LocalDateTime orderTime;

    private String buyer;

    private String paymentMethod;

    private int totalCost;

    private int shippingFee;

    private String postalCode;

    private String address;

    private String requestContent;


    //private static class Order
}
