package br.com.betApi.application.core.user.dto;

import br.com.betApi.application.core.role.dto.RoleSimpleDto;
import br.com.betApi.domain.vo.enums.StatusUser;

import java.util.List;


public record UserInputDto(Long id,
                           String email,
                           String password,
                           StatusUser status,
                           List<RoleSimpleDto> roles) {

}
