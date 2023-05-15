package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.domain.constant.DeliveryState;
import ebnatural.bizcurator.apiserver.dto.PaymentDetailDto;
import ebnatural.bizcurator.apiserver.dto.PaymentHistoryDto;
import ebnatural.bizcurator.apiserver.dto.PaymentHistoryDto.OrderHistoryDto;
import ebnatural.bizcurator.apiserver.dto.request.CancelOrderRequest;
import ebnatural.bizcurator.apiserver.dto.response.CommonResponse;
import ebnatural.bizcurator.apiserver.service.MyPageService;
import java.util.HashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/mypages")
@RestController
public class MyPageController {

    private final MyPageService myPageService;

    @GetMapping("/orders/products")
    public ResponseEntity<CommonResponse> showOrderHistoryList(
            @RequestParam(value = "filter-month", required = false) Integer filterMonth,
            @RequestParam(value = "delivery-state", required = false) String deliveryStateText) {

        List<PaymentHistoryDto> paymentHistoryResponseList = myPageService.getAllPaymentHistory(filterMonth, deliveryStateText);
        HashMap<String, Object> historyMap = new HashMap<>();
        historyMap.put("histories", paymentHistoryResponseList);
        return CommonResponse.ok(HttpStatus.OK.value(), "조회가 완료됐습니다.", historyMap);
    }

    @GetMapping("/orders/products/details")
    public ResponseEntity<CommonResponse> showOrderHistoryDetailByPaymentId(
            @RequestParam(value = "payment-id") Long paymentId){

        PaymentDetailDto paymentDetailDtoList = myPageService.getAllPaymentDetails(paymentId);
        HashMap<String, Object> historyMap = new HashMap<>();
        historyMap.put("details", paymentDetailDtoList);
        return CommonResponse.ok(HttpStatus.OK.value(), "상세 조회가 완료됐습니다.", historyMap);
    }

    @PostMapping("/orders/cancellations")
    public ResponseEntity<CommonResponse> cancelOrder(@RequestBody CancelOrderRequest cancelOrderRequest) {
        myPageService.cancelOrder(cancelOrderRequest);
        return CommonResponse.ok(HttpStatus.OK.value(), "취소 신청이 완료되었습니다.");
    }
}
