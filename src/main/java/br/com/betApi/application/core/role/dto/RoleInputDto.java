package br.com.betApi.application.core.role.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RoleInputDto(
        Long id,
        @NotBlank(message = "A descrição é um campo obrigatório.")
        @Size(min = 5,max = 100)
        String description) {
}
