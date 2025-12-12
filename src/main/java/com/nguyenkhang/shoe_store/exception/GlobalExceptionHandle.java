package com.nguyenkhang.shoe_store.exception;

import java.util.Map;
import java.util.Objects;

import jakarta.validation.ConstraintViolation;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.nguyenkhang.shoe_store.dto.ApiResponseDTO;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandle {

    private static final String MIN_ATTRIBUTE = "min";

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponseDTO> handlingException(Exception exception) {
        log.error("Exception: ", exception);

        ApiResponseDTO apiResponseDTO = new ApiResponseDTO<>();

        ErrorCode errorCode = ErrorCode.UNCATEGORIZED_EXCEPTION;

        apiResponseDTO.setCode(errorCode.getCode());
        apiResponseDTO.setMessage(errorCode.getMessage());
        return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponseDTO);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponseDTO> handlingAppException(AppException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();

        apiResponseDTO.setCode(errorCode.getCode());
        apiResponseDTO.setMessage(errorCode.getMessage());

        return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponseDTO);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponseDTO> handlingValidation(MethodArgumentNotValidException exception) {

        String enumKey = exception.getFieldError().getDefaultMessage();

        Map<String, Object> attributes = null;
        ErrorCode errorCode;
        try {

            errorCode = ErrorCode.valueOf(enumKey);

            ConstraintViolation constraintViolation =
                    exception.getBindingResult().getFieldErrors().getFirst().unwrap(ConstraintViolation.class);

            attributes = constraintViolation.getConstraintDescriptor().getAttributes();
            log.info(attributes.toString());
        } catch (IllegalArgumentException ignored) {
            log.error("Error: ", ignored);

            log.error(enumKey);
            errorCode = ErrorCode.INVALID_KEY;
        }
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();

        apiResponseDTO.setCode(errorCode.getCode());
        apiResponseDTO.setMessage(
                Objects.nonNull(attributes)
                        ? mapAttribute(errorCode.getMessage(), attributes)
                        : errorCode.getMessage());

        return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponseDTO);
    }

    @ExceptionHandler(value = AuthorizationDeniedException.class)
    ResponseEntity<ApiResponseDTO> handlingAuthorizationDeniedException(AuthorizationDeniedException exception) {
        ErrorCode errorCode = ErrorCode.UNAUTHORIZED;

        return ResponseEntity.status(errorCode.getStatusCode())
                .body(ApiResponseDTO.builder()
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .build());
    }

    @ExceptionHandler(value = NoResourceFoundException.class)
    ResponseEntity<ApiResponseDTO> handingNoResourceFoundException(NoResourceFoundException exception) {
        ErrorCode errorCode = ErrorCode.NOT_FOUND_API_PATH;
        return ResponseEntity.status(errorCode.getStatusCode())
                .body(ApiResponseDTO.builder()
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .build());
    }

    private String mapAttribute(String message, Map<String, Object> attributes) {
        String minValue = String.valueOf(attributes.get(MIN_ATTRIBUTE));

        return message.replace("{" + MIN_ATTRIBUTE + "}", minValue);
    }
}
