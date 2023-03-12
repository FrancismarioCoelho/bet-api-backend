package br.com.betApi.application.core.role.dto;

import br.com.betApi.domain.model.user.aggregates.role.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public record RoleOutputDto(Role role) {
    private static Long id;
    private static String description;

    public RoleOutputDto {
        id = role.getId();
        description = role.getDescription();
    }

}
