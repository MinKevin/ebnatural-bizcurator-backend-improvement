package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.dto.AdminHomeInfoDto;
import ebnatural.bizcurator.apiserver.dto.AdminOrderDetailDto;
import ebnatural.bizcurator.apiserver.dto.PaymentHistoryDto;
import ebnatural.bizcurator.apiserver.dto.response.CommonResponse;
import ebnatural.bizcurator.apiserver.service.AdminOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.HashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/orders")
    public ResponseEntity<CommonResponse> showOrderDetailList(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "search", required = false) String search) {

        List<AdminOrderDetailDto> adminOrderDetailDtoList =
                adminOrderService.showOrderDetailListByPageIndexAndSearchKeyword(page, search);
        HashMap<String, Object> historyMap = new HashMap<>();
        historyMap.put("histories", adminOrderDetailDtoList);
        return CommonResponse.ok(HttpStatus.OK.value(), "관리자 페이지 주문내역 조회 완료했습니다.", historyMap);
    }
}
