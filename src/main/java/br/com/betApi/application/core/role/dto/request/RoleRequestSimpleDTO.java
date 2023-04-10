package br.com.betApi.application.core.role.dto.request;

import jakarta.validation.constraints.NotNull;

public record RoleRequestSimpleDTO(@NotNull(message = "Informe o papel do usuário.") Long id){
}
