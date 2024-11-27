package br.com.ecommerce.api.exception.handler;

import br.com.ecommerce.api.exception.handler.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String errorCode;
    private String message;

    public static ErrorResponse fromErrorCode(ErrorCode errorCode) {
        return new ErrorResponse(errorCode.getCode(), errorCode.getDescription());
    }
}
