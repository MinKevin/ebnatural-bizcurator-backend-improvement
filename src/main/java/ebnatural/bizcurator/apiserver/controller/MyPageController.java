package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.dto.response.PaymentHistoryResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/mypages")
@RestController
public class MyPageController {

    @GetMapping("/orders/products")
    public ResponseEntity<List<PaymentHistoryResponse>> showOrderHistoryList(
            @RequestParam("filter-month") String filterMonth,
            @RequestParam("delivery-state") String deliveryState) {

        // todo: filter-month와 delivery-state 값을 사용하여 필터링된 데이터를 가져오는 로직을 작성합니다.
        List<PaymentHistoryResponse> paymentHistoryResponseList = null;

        // 필터링된 제품 목록을 반환합니다.
        return ResponseEntity.ok(paymentHistoryResponseList);
    }
}
