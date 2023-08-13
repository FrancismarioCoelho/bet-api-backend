package br.com.betApi.application.core.user.dto.request;

import br.com.betApi.application.core.person.dto.request.PersonRequestDTO;
import br.com.betApi.application.core.role.dto.request.RoleRequestSimpleDTO;
import br.com.betApi.domain.vo.enums.StatusUser;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;


public record UserRequestDTO(Long id,
                             @NotBlank(message = "Informe o campo de senha.")
                             @Size(min = 8, max = 8, message = "Insira uma senha com 8 caracteres.")
                             String password,
                             @NotNull(message = "Informe o estado atual.")
                             StatusUser status,
                             @NotNull(message = "Informe o papel do usuário.")
                             List<RoleRequestSimpleDTO> roles,
                             @Valid PersonRequestDTO person
) {
    public UserRequestDTO(Long id, String password, StatusUser status, List<RoleRequestSimpleDTO> roles, PersonRequestDTO person) {
        this.id = id;
        this.password = password;
        this.status = status;
        this.roles = roles;
        this.person = person;
    }

}
