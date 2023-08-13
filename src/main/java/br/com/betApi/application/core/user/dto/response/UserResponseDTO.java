package br.com.betApi.application.core.user.dto.response;

import br.com.betApi.application.core.role.dto.response.RoleResponseDTO;
import br.com.betApi.domain.model.user.User;
import br.com.betApi.domain.vo.enums.StatusUser;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record UserResponseDTO(Long id,
                              LocalDateTime createAt,
                              StatusUser status,
                              List<RoleResponseDTO> roles) {


    public UserResponseDTO(User user) {
        this(user.getId(), user.getCreateAt(), user.getStatus(),
                user.getRoles().stream().map(RoleResponseDTO::new).collect(Collectors.toList()));
    }
}
