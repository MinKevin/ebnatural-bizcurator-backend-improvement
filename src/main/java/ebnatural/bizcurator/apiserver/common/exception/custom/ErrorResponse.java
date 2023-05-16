package ebnatural.bizcurator.apiserver.common.exception.custom;

import java.util.List;


public class ErrorResponse {
    Integer errorCode;
    String ErrorMessage;
    List fieldErrors;

    private ErrorResponse(Integer errorCode, String errorMessage, List fieldErrors) {
        this.errorCode = errorCode;
        this.ErrorMessage = errorMessage;
        this.fieldErrors = fieldErrors;
    }

    public static ErrorResponse of(Integer errorCode, String errorMessage) {
        return new ErrorResponse(errorCode, errorMessage, null);
        }

public static ErrorResponse of(Integer errorCode, String errorMessage, List fieldErrors) {
        return new ErrorResponse(errorCode, errorMessage, fieldErrors);
        }



        }