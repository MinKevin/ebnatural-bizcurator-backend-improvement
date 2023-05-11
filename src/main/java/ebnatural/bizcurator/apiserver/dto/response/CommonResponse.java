package ebnatural.bizcurator.apiserver.dto.response;

import lombok.Getter;

import java.util.Map;

@Getter
public abstract class CommonResponse {

    private String status;
    private Integer code;
    private String message;
    private Map<String, Object> result;

    public CommonResponse() {
    }

    public CommonResponse(String status, Integer code, String message, Map<String, Object> result) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.result = result;
    }
}
