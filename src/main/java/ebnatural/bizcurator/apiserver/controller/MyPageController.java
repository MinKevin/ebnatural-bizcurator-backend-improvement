package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.dto.PaymentHistoryDto;
import ebnatural.bizcurator.apiserver.dto.response.PaymentHistoryResponse;
import ebnatural.bizcurator.apiserver.service.MyPageService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

@RequiredArgsConstructor
@RequestMapping("/api/mypages")
@RestController
public class MyPageController {


    private final MyPageService myPageService;

    @GetMapping("/orders/products")
    public ResponseEntity<PaymentHistoryResponse> showOrderHistoryList(
            @RequestParam(value = "filter-month", required = false) String filterMonth,
            @RequestParam(value = "delivery-state", required = false) String deliveryState) {

        List<PaymentHistoryDto> paymentHistoryResponseList = myPageService.getAllPaymentHistory();
        return PaymentHistoryResponse.ok("조회 완료했습니다.", paymentHistoryResponseList);
    }
}
