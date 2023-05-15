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
    ENTITY_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "entity already exists")
    ;

    private final HttpStatus httpStatusCode;
    private final String message;
}

