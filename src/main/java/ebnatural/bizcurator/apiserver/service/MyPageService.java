package ebnatural.bizcurator.apiserver.service;

import ebnatural.bizcurator.apiserver.domain.OrderDetail;
import ebnatural.bizcurator.apiserver.dto.response.PaymentHistoryResponse;
import ebnatural.bizcurator.apiserver.repository.OrderDetailRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyPageService {

    private final OrderDetailRepository orderDetailRepository;

    public List<PaymentHistoryResponse> getAllPaymentHistory() {
        List<OrderDetail> orderDetailList = orderDetailRepository.findAll();

        Map<Long, List<OrderDetail>> paymentGroups = new HashMap<>();
        for (OrderDetail orderDetail : orderDetailList) {
            Long paymentId = orderDetail.getPaymentId();

            List<OrderDetail> paymentGroup = paymentGroups.getOrDefault(paymentId, new ArrayList<>());
            paymentGroup.add(orderDetail);
            paymentGroups.put(paymentId, paymentGroup);
        }
        // PaymentHistoryResponse로 변환하여 반환할 리스트 생성
//        List<PaymentHistoryResponse> paymentHistoryResponseList = paymentGroups.entrySet().stream()
//                .map(entry -> createPaymentHistoryResponse(entry.getKey(), entry.getValue()))
//                .collect(Collectors.toList());


        return null;
    }

}
