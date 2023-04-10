package br.com.betApi.application.core.role.dto.response;

import br.com.betApi.domain.model.user.aggregates.role.Role;

public record RoleResponseDTO(Role role) {
    private static Long id;
    private static String description;

    public RoleResponseDTO {
        id = role.getId();
        description = role.getDescription();
    }

}
