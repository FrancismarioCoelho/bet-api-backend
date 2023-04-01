package br.com.betApi.application.core.user.dto;

import br.com.betApi.application.core.person.dto.PersonInputDto;
import br.com.betApi.application.core.role.dto.RoleSimpleDto;
import br.com.betApi.domain.vo.enums.StatusUser;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;


public record UserInputDto(Long id,
                           @Email(message = "O email informado não é válido.")
                           String email,
                           @NotBlank(message = "Informe o campo de senha.")
                           @Size(min = 8,max = 8,message = "Insira uma senha com 8 caracteres.")
                           String password,
                           @NotNull(message = "Informe o estado atual.")
                           StatusUser status,
                           @NotNull(message = "Informe o papel do usuário.")
                           List<RoleSimpleDto> roles,
                           PersonInputDto person
                           ) {

}
