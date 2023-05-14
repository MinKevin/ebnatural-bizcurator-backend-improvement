package ebnatural.bizcurator.apiserver.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.FieldError;

@Getter
public class ErrorResponse {

    private Integer errorCode;
    private String errorMessage;
    private List<FieldError> fieldErrors;

    protected ErrorResponse() {
    }

    private ErrorResponse(Integer errorCode, String errorMessage, List<FieldError> fieldErrors) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.fieldErrors = fieldErrors;
    }

    public static ErrorResponse of(Integer errorCode, String errorMessage) {
        return new ErrorResponse(errorCode, errorMessage, null);
    }

    public static ErrorResponse of(Integer errorCode, String errorMessage, List fieldErrors) {
        return new ErrorResponse(errorCode, errorMessage, fieldErrors);
    }

}
