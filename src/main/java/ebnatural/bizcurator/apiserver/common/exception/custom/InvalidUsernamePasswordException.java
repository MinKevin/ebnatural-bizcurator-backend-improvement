package ebnatural.bizcurator.apiserver.common.exception.custom;


import ebnatural.bizcurator.apiserver.common.exception.custom.ErrorCode;

public class InvalidUsernamePasswordException extends RuntimeException {
    private ErrorCode errorCode;

    public InvalidUsernamePasswordException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}