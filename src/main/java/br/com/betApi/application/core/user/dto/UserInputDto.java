package br.com.betApi.application.core.user.dto;

import br.com.betApi.domain.vo.enums.StatusUser;
import br.com.betApi.domain.model.user.aggregates.role.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

public record UserInputDto(Long id,
                           @NotBlank
                           @Email
                           String email,
                           @NotBlank
                           @Size(min = 8, max = 8)
                           String password,
                           LocalDateTime createAt,
                           @NotNull
                           StatusUser status,
                           @NotNull
                           List<Role> roles) {
}
