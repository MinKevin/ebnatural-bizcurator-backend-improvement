package ebnatural.bizcurator.apiserver.common.exception;

import ebnatural.bizcurator.apiserver.common.exception.custom.CategoryNotFoundException;
import ebnatural.bizcurator.apiserver.common.exception.custom.ErrorCode;
import ebnatural.bizcurator.apiserver.common.exception.custom.ProductNotFoundException;
import ebnatural.bizcurator.apiserver.dto.response.ErrorResponse;
import ebnatural.bizcurator.apiserver.dto.response.ResponseStatusType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // CategoryNotFoundException 에러 처리
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Object> handleCategoryNotFoundException(CategoryNotFoundException e) {
        log.warn("handleCategoryNotFoundException", e);
        return handleExceptionInternal(ErrorCode.CATEGORY_NOT_FOUND, e.getMessage());
    }
    // ProductNotFoundException 에러 처리
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException e) {
        log.warn("handleProductNotFoundException", e);
        return handleExceptionInternal(ErrorCode.PRODUCT_NOT_FOUND, e.getMessage());
    }

    // IllegalArgumentException 에러 처리
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgument(IllegalArgumentException e) {
        log.warn("handleIllegalArgument", e);
        return handleExceptionInternal(ErrorCode.ILLEGAL_ARGUMENT, ErrorCode.ILLEGAL_ARGUMENT.getMessage());
    }

    // MethodArgumentTypeMismatchException 에러 처리
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException e) {
        log.warn("handleMethodArgumentTypeMismatch", e);
        return handleExceptionInternal(ErrorCode.METHOD_ARGUMENT_TYPE_MISMATCH, ErrorCode.METHOD_ARGUMENT_TYPE_MISMATCH.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException e) {
        log.warn("handleDataIntegrityViolation", e);
        return handleExceptionInternal(ErrorCode.DATA_INTEGRITY_VIOLATION, ErrorCode.DATA_INTEGRITY_VIOLATION.getMessage());
    }

    // @Valid 어노테이션으로 넘어오는 에러 처리
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("handleBindException", ex);
        return handleExceptionInternal(ex);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("handleMissingServletRequestParameter", ex);
        return handleExceptionInternal(ErrorCode.MISSING_SERVLET_REQUEST_PARAMETER, ErrorCode.MISSING_SERVLET_REQUEST_PARAMETER.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("handleMissingPathVariable", ex);
        return handleExceptionInternal(ErrorCode.MISSING_PATH_VARIABLE, ErrorCode.MISSING_PATH_VARIABLE.getMessage());
    }

    // 대부분의 에러 처리
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAllException(Exception ex) {
        log.warn("handleAllException", ex);
        return handleExceptionInternal();
    }

    private ResponseEntity<Object> handleExceptionInternal() {
        return ResponseEntity.status(ErrorCode.INTERNAL_SERVER_ERROR.getHttpStatusCode())
                .body(makeErrorResponse());
    }

    private ResponseEntity<Object> handleExceptionInternal(BindException e) {
        return ResponseEntity.status(ErrorCode.BIND_EXCEPTION.getHttpStatusCode())
                .body(makeErrorResponse(e));
    }

    private ResponseEntity<Object> handleExceptionInternal(ErrorCode errorCode, String message) {
        return ResponseEntity.status(errorCode.getHttpStatusCode())
                .body(makeErrorResponse(errorCode, message));
    }

    private ErrorResponse makeErrorResponse() {
        return ErrorResponse.builder()
                .status(ResponseStatusType.ERROR)
                .code(ErrorCode.INTERNAL_SERVER_ERROR.getHttpStatusCode().value())
                .message(ErrorCode.INTERNAL_SERVER_ERROR.getMessage())
                .build();
    }

    private ErrorResponse makeErrorResponse(ErrorCode errorCode, String message) {
        return ErrorResponse.builder()
                .status(ResponseStatusType.ERROR)
                .code(errorCode.getHttpStatusCode().value())
                .message(message)
                .build();
    }

    private ErrorResponse makeErrorResponse(BindException e) {
        List<ErrorResponse.ValidationError> validationErrorList = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(ErrorResponse.ValidationError::of)
                .collect(Collectors.toList());

        return ErrorResponse.builder()
                .status(ResponseStatusType.ERROR)
                .code(ErrorCode.BIND_EXCEPTION.getHttpStatusCode().value())
                .message(ErrorCode.BIND_EXCEPTION.getMessage())
                .errors(validationErrorList)
                .build();
    }
}
