package br.com.betApi.application.core.role.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RoleRequestDTO(
        Long id,
        @NotBlank(message = "A descrição é um campo obrigatório.")
        @Size(min = 5,max = 50)
        String name,
        @NotBlank(message = "A descrição é um campo obrigatório.")
        @Size(min = 5,max = 500)
        String description) {
}
