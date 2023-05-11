package ebnatural.bizcurator.apiserver.dto.response;

import ebnatural.bizcurator.apiserver.dto.ArticleDto;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ArticleResponse extends CommonResponse {

    public ArticleResponse() {
    }

    public ArticleResponse(String status, Integer code, String message, Map<String, Object> result) {
        super(status, code, message, result);
    }

    public static ArticleResponse of(String status, Integer code, String message, List<ArticleDto> result) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("articles", result);
        return new ArticleResponse(status, code, message, map);
    }

    public static ArticleResponse of(String status, Integer code, String message) {
        return new ArticleResponse(status, code, message, null);
    }

    public static ResponseEntity<ArticleResponse> ok(String message, List<ArticleDto> result) {
        return ResponseEntity.ok(ArticleResponse.of("OK", 200, message, result));
    }

    public static ResponseEntity<ArticleResponse> ok(String message) {
        return ResponseEntity.ok(ArticleResponse.of("OK", 200, message));
    }

public static ResponseEntity<ArticleResponse> error(String message) {
        return ResponseEntity.badRequest().body(ArticleResponse.of("ERROR", 400, message, null));
    }
}
