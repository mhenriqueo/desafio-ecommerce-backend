package br.com.ecommerce.api.exception.handler.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR("E000-000", "Erro interno do servidor"),
    NOT_FOUND("E001-001", "Recurso não encontrado"),
    BAD_REQUEST("E002-001", "Requisição inválida"),
    CONFLICT("E003-001", "Conflito de dados"),
    UNPROCESSABLE_ENTITY("E004-001", "Entidade não processável");

    private String code;
    private String description;
}
