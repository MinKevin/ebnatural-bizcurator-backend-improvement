package ebnatural.bizcurator.apiserver.common.exception.custom;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    ILLEGAL_ARGUMENT(HttpStatus.BAD_REQUEST, "Illegal argument"),
    MISSING_SERVLET_REQUEST_PARAMETER(HttpStatus.BAD_REQUEST, "Missing servlet request parameter"),
    MISSING_PATH_VARIABLE(HttpStatus.BAD_REQUEST, "Missing path variable"),
    METHOD_ARGUMENT_TYPE_MISMATCH(HttpStatus.BAD_REQUEST, "Method argument type mismatch"),
    BIND_EXCEPTION(HttpStatus.BAD_REQUEST, "Bind exception"),
    DATA_INTEGRITY_VIOLATION(HttpStatus.BAD_REQUEST, "Data integrity violation"),
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "Resource not exists"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),
    CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "Category not found"),
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "Product not found"),
    IMAGE_UPLOAD_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Image upload error"),
    NOT_IMAGE_FILE(HttpStatus.BAD_REQUEST, "Not image file"),
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "entity not exists"),
    ENTITY_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "entity already exists"),
    ALREADY_REGISTERED_USER_EXCEPTION(HttpStatus.CONFLICT, "username already exists"),
    JWT_EXPIRED(HttpStatus.BAD_REQUEST, "토큰이 만료됐습니다."),
    JWT_WRONG(HttpStatus.BAD_REQUEST, "토큰값이 올바르지 않습니다."),
    AUTHENTICATION_WRONG(HttpStatus.UNAUTHORIZED, "인증되지 않은 사용자입니다."),
    AUTHORIZATION_WRONG(HttpStatus.FORBIDDEN, "권한이 없는 사용자입니다."),
    BAD_CREDENTIALS(HttpStatus.BAD_REQUEST, "Access Token 의 잘못된 계정정보입니다."),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR ,"서버 오류로 정상적으로 요청을 처리할 수 없습니다."),
    USERNAME_OR_PASSWORD_WRONG(HttpStatus.BAD_REQUEST, "아이디 또는 비밀번호가 올바르지 않습니다."),
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "회원을 찾을 수 없습니다.")
    ;

    private final HttpStatus httpStatusCode;
    private final String message;
}

