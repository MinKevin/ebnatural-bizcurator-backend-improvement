package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.dto.AdminHomeInfoDto;
import ebnatural.bizcurator.apiserver.dto.PaymentHistoryDto;
import ebnatural.bizcurator.apiserver.dto.response.CommonResponse;
import ebnatural.bizcurator.apiserver.service.AdminOrderService;
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
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admins")
public class AdminOrderController {

    private final AdminOrderService adminOrderService;

    @GetMapping("/home")
    public ResponseEntity<CommonResponse> showHome() {
        AdminHomeInfoDto adminHomeInfoDto = adminOrderService.showHomeInformation();
        HashMap<String, Object> historyMap = new HashMap<>();
        historyMap.put("histories", adminHomeInfoDto);
        return CommonResponse.ok(HttpStatus.OK.value(), "관리자 페이지 홈화면 로드 완료했습니다.", historyMap);
    }
}
