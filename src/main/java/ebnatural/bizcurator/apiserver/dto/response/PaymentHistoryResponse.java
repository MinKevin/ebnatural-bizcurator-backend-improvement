package ebnatural.bizcurator.apiserver.dto.response;

import ebnatural.bizcurator.apiserver.domain.constant.DeliveryState;
import ebnatural.bizcurator.apiserver.dto.ArticleDto;
import ebnatural.bizcurator.apiserver.dto.PaymentHistoryDto;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Setter
public class PaymentHistoryResponse extends CommonResponse{

    public PaymentHistoryResponse() {
    }

    public PaymentHistoryResponse(String status, Integer code, String message, Map<String, Object> result) {
        super(status, code, message, result);
    }

    public static PaymentHistoryResponse of(String status, Integer code, String message, List<PaymentHistoryDto> result) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("histories", result);
        return new PaymentHistoryResponse(status, code, message, map);
    }

    public static ResponseEntity<PaymentHistoryResponse> ok(String message, List<PaymentHistoryDto> result) {
        return ResponseEntity.ok(PaymentHistoryResponse.of("OK", 200, message, result));
    }

}
