package ebnatural.bizcurator.apiserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.querydsl.core.Tuple;
import ebnatural.bizcurator.apiserver.dto.ApplicationDetailDto;
import ebnatural.bizcurator.apiserver.dto.ApplicationDto;
import ebnatural.bizcurator.apiserver.dto.MemberPrincipalDetails;
import ebnatural.bizcurator.apiserver.dto.MyPageHomeDto;
import ebnatural.bizcurator.apiserver.dto.PaymentDetailDto;
import ebnatural.bizcurator.apiserver.dto.PaymentHistoryDto;
import ebnatural.bizcurator.apiserver.dto.request.CancelOrderRequest;
import ebnatural.bizcurator.apiserver.dto.request.MemberRequest;
import ebnatural.bizcurator.apiserver.dto.request.RefundOrderRequest;
import ebnatural.bizcurator.apiserver.dto.response.CommonResponse;
import ebnatural.bizcurator.apiserver.service.MemberService;
import ebnatural.bizcurator.apiserver.service.MyPageService;
import java.util.HashMap;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RequestMapping("/api/mypages")
@RestController
public class MyPageController {

    private final MyPageService myPageService;
    private final ObjectMapper objectMapper;

    private final MemberService memberService;

    @GetMapping
    // todo: 시큐리티 설정하면 주석 해제
    //public ResponseEntity<CommonResponse> showHome(@AuthenticationPrincipal MemberPrincipalDetails memberPrincipalDetails) {
    //    MyPageHomeDto myPageHomeDto = myPageService.showHome(memberPrincipalDetails.getId());
    public ResponseEntity<CommonResponse> showHome() {
        MyPageHomeDto myPageHomeDto = myPageService.showHome(1L);
        HashMap<String, Object> historyMap = new HashMap<>();
        historyMap.put("histories", myPageHomeDto);
        return CommonResponse.ok(HttpStatus.OK.value(), "홈 화면 로드 완료됐습니다.", historyMap);
    }

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

    @PostMapping("/orders/refunds")
    public ResponseEntity<CommonResponse> refundOrder(@RequestBody RefundOrderRequest refundOrderRequest) {
        myPageService.refundOrder(refundOrderRequest);
        return CommonResponse.ok(HttpStatus.OK.value(), "환불 신청이 완료되었습니다.");
    }

    @GetMapping("/orders/applications/cancellations")
    public ResponseEntity<CommonResponse> showCancelApplicationsList(
                                @RequestParam(value = "filter-month", required = false) Integer filterMonth) {

        List<ApplicationDto> applicationDtoList = myPageService.showCancelApplicationList(filterMonth);
        HashMap<String, Object> historyMap = new HashMap<>();
        historyMap.put("details", applicationDtoList);
        return CommonResponse.ok(HttpStatus.OK.value(), "주문 취소 리스트 조회가 완료되었습니다.", historyMap);
    }

    @GetMapping("/orders/applications/refunds")
    public ResponseEntity<CommonResponse> showRefundApplicationsList(
            @RequestParam(value = "filter-month", required = false) Integer filterMonth) {

        List<ApplicationDto> applicationDtoList = myPageService.showRefundApplicationList(filterMonth);
        HashMap<String, Object> historyMap = new HashMap<>();
        historyMap.put("details", applicationDtoList);
        return CommonResponse.ok(HttpStatus.OK.value(), "주문 환불 리스트 조회가 완료되었습니다.", historyMap);
    }

    @GetMapping("/orders/applications/cancellations/details")
    public ResponseEntity<CommonResponse> showCancelApplicationDetail(
            @RequestParam(value = "cancel-id") Long cancelId) {
        ApplicationDetailDto applicationDetailDto = myPageService.showCancelApplicationDetail(cancelId);
        HashMap<String, Object> historyMap = new HashMap<>();
        historyMap.put("details", applicationDetailDto);
        return CommonResponse.ok(HttpStatus.OK.value(), "주문 취소 상세 조회가 완료되었습니다.", historyMap);
    }
    @GetMapping("/orders/applications/refunds/details")
    public ResponseEntity<CommonResponse> showRefundApplicationDetail(
            @RequestParam(value = "refund-id") Long refundId) {
        ApplicationDetailDto applicationDetailDto = myPageService.showRefundApplicationDetail(refundId);
        HashMap<String, Object> historyMap = new HashMap<>();
        historyMap.put("details", applicationDetailDto);
        return CommonResponse.ok(HttpStatus.OK.value(), "주문 환불 상세 조회가 완료되었습니다.", historyMap);
    }

    /**
     * 회원정보 수정
     * @param memberDto
     * @param image
     * @return
     */
    @PutMapping("/info")
    public ResponseEntity<CommonResponse> changeMemberInfo(
            @Valid @RequestPart(value = "post", required = true) MemberRequest memberDto,
            @RequestPart(value = "image") MultipartFile image) {

        memberService.updateMember(memberDto, image);
        return CommonResponse.ok(HttpStatus.CREATED.value(), "update success");
    }

}
