package br.com.betApi.application.core.user.dto;

import br.com.betApi.application.core.role.dto.RoleOutputDto;
import br.com.betApi.domain.model.person.Person;
import br.com.betApi.domain.model.user.User;
import br.com.betApi.domain.model.user.aggregates.role.Role;
import br.com.betApi.domain.vo.enums.StatusUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record UserOutputDto(User user) {

    private static Long id;
    private static String email;
    private static LocalDateTime createAt; 
    private static StatusUser status; 
    private static List<RoleOutputDto> roles;

    public UserOutputDto {
        id = user.getId();
        email = user.getEmail();
        createAt = user.getCreateAt();
        status = user.getStatus();
        roles = user.getRoles().stream().map(RoleOutputDto::new).collect(Collectors.toList());
    }
}
