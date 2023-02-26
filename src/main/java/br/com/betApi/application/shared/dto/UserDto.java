package br.com.betApi.application.shared.dto;

import br.com.betApi.domain.enums.StatusUser;
import br.com.betApi.domain.model.user.aggregates.role.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
public class UserDto{

    private Long id;
    private String email;
    private String password;
    private LocalDateTime createAt;
    private StatusUser status;
    private List<Role> roles = new ArrayList<>();


}
