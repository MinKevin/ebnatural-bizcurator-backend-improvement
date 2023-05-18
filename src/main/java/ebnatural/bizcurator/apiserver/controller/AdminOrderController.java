package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.dto.AdminApplicationDto;
import ebnatural.bizcurator.apiserver.dto.AdminHomeInfoDto;
import ebnatural.bizcurator.apiserver.dto.AdminOrderDetailDto;
import ebnatural.bizcurator.apiserver.dto.PaymentHistoryDto;
import ebnatural.bizcurator.apiserver.dto.response.CommonResponse;
import ebnatural.bizcurator.apiserver.service.AdminOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 관리자페이지 
 *      - 홈화면
 *      - 주문 배송 관련
 *      - 취소, 환불 신청 내역 관련
 */
@Tag(name = "관리자페이지", description = "관리자페이지 주문내역 관련 api 입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admins")
public class AdminOrderController {

    private final AdminOrderService adminOrderService;

    @Operation(summary = "홈화면 메서드", description = "홈화면 메서드입니다.")
    @GetMapping("/home")
    public ResponseEntity<CommonResponse> showHome() {
        AdminHomeInfoDto adminHomeInfoDto = adminOrderService.showHomeInformation();
        HashMap<String, Object> historyMap = new HashMap<>();
        historyMap.put("histories", adminHomeInfoDto);
        return CommonResponse.ok(HttpStatus.OK.value(), "관리자 페이지 홈화면 로드 완료했습니다.", historyMap);
    }

    @Operation(summary = "주문내역 조회 메서드", description = "주문내역 조회 메서드입니다.")
    @GetMapping("/orders")
    public ResponseEntity<CommonResponse> showOrderDetailList(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "search", required = false) String search) {

        Pair<Integer, List<AdminOrderDetailDto>> adminOrderDetailsPair =
                adminOrderService.showOrderDetailListByPageIndexAndSearchKeyword(page, search);
        // dataTotalCount가 histories 보다 앞에 출력됐으면 해서 순서가 보장되는 LinkedHashMap으로 수정함.
        LinkedHashMap<String, Object> historyMap = new LinkedHashMap<>();
        historyMap.put("dataTotalCount", adminOrderDetailsPair.getFirst());
        historyMap.put("histories", adminOrderDetailsPair.getSecond());
        return CommonResponse.ok(HttpStatus.OK.value(), "관리자 페이지 주문내역 조회 완료했습니다.", historyMap);
    }

    @Operation(summary = "주문 취소신청 내역", description = "조회 메서드")
    @GetMapping("/applications/cancellations")
    public ResponseEntity<CommonResponse> showCancelApplications(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "search", required = false) String search) {

        Pair<Integer, List<AdminApplicationDto>> adminApplicationPair =
                adminOrderService.showOrderCancelListByPageIndexAndSearchKeyword(page, search);
        // dataTotalCount가 histories 보다 앞에 출력됐으면 해서 순서가 보장되는 LinkedHashMap으로 수정함.
        LinkedHashMap<String, Object> historyMap = new LinkedHashMap<>();
        historyMap.put("dataTotalCount", adminApplicationPair.getFirst());
        historyMap.put("histories", adminApplicationPair.getSecond());
        return CommonResponse.ok(HttpStatus.OK.value(), "관리자 페이지 주문 취소신청 조회 완료했습니다.", historyMap);
    }

    @Operation(summary = "주문 환불신청 내역", description = "조회 메서드")
    @GetMapping("/applications/refunds")
    public ResponseEntity<CommonResponse> showRefundApplications(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "search", required = false) String search) {

        Pair<Integer, List<AdminApplicationDto>> adminApplicationPair =
                adminOrderService.showOrderRefundListByPageIndexAndSearchKeyword(page, search);
        // dataTotalCount가 histories 보다 앞에 출력됐으면 해서 순서가 보장되는 LinkedHashMap으로 수정함.
        LinkedHashMap<String, Object> historyMap = new LinkedHashMap<>();
        historyMap.put("dataTotalCount", adminApplicationPair.getFirst());
        historyMap.put("histories", adminApplicationPair.getSecond());
        return CommonResponse.ok(HttpStatus.OK.value(), "관리자 페이지 주문 환불신청 조회 완료했습니다.", historyMap);
    }
}
