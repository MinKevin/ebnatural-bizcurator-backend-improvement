package ebnatural.bizcurator.apiserver.service;

import ebnatural.bizcurator.apiserver.domain.OrderDetail;
import ebnatural.bizcurator.apiserver.dto.PaymentHistoryDto;
import ebnatural.bizcurator.apiserver.dto.PaymentHistoryDto.OrderHistoryDto;
import ebnatural.bizcurator.apiserver.repository.OrderDetailRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyPageService {

    private final OrderDetailRepository orderDetailRepository;
    // todo: 시큐리티 완성되면 수정
    //private final JwtProvider jwtProvider;

    public List<PaymentHistoryDto> getAllPaymentHistory() {
        // todo: 시큐리티 완성되면 수정
        Long memberId = 1L; // jwtProvider.getUserIDByToken(accessToken);
        List<OrderDetail> orderDetailList = orderDetailRepository.findAllByMemberId(memberId);

        if (orderDetailList.isEmpty()) {
            return null;
        }

        Map<Long, List<OrderDetail>> paymentGroupMap = new HashMap<>();
        for (OrderDetail orderDetail : orderDetailList) {
            Long paymentId = orderDetail.getPaymentId();

            List<OrderDetail> paymentGroup = paymentGroupMap.getOrDefault(paymentId, new ArrayList<>());
            paymentGroup.add(orderDetail);
            paymentGroupMap.put(paymentId, paymentGroup);
        }

        List<PaymentHistoryDto> paymentHistoryDtoList = paymentGroupMap.entrySet().stream()
                .map(entry -> createPaymentHistoryResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        return paymentHistoryDtoList;
    }

    private PaymentHistoryDto createPaymentHistoryResponse(Long paymentId, List<OrderDetail> orderDetails) {
        List<OrderHistoryDto> orderHistoryDtoList = new ArrayList<>();

        for (OrderDetail orderDetail : orderDetails) {
            OrderHistoryDto orderHistoryResponse = OrderHistoryDto.of(orderDetail.getId(), "", orderDetail.getDeliveryState(), orderDetail.getOrderTime(),
                    "", orderDetail.getQuantity(), orderDetail.getCost());

            orderHistoryDtoList.add(orderHistoryResponse);
        }

        PaymentHistoryDto paymentHistoryDto = PaymentHistoryDto.of(paymentId, orderHistoryDtoList);
        return paymentHistoryDto;
    }


}
