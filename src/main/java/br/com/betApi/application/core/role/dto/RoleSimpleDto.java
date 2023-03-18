package br.com.betApi.application.core.role.dto;

import jakarta.validation.constraints.NotNull;

public record RoleSimpleDto(@NotNull(message = "Informe o papel do usuário.") Long id){
}
