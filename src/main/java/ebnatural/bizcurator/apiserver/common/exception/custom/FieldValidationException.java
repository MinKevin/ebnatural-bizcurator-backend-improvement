package ebnatural.bizcurator.apiserver.common.exception.custom;

import lombok.Getter;
import org.springframework.validation.BindingResult;

@Getter
public class FieldValidationException extends CustomException {
    public FieldValidationException(ErrorCode errorCode) {
        super(ErrorCode.FIELD_VALIDATION_FAILED);
    }
}