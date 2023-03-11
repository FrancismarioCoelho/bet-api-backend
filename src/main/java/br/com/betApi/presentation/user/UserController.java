package br.com.betApi.presentation.user;

import br.com.betApi.application.core.user.dto.UserInputDto;
import br.com.betApi.domain.model.user.User;
import br.com.betApi.domain.service.users.IUserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private IUserService userService;

    @PostMapping
    private User save(@RequestBody @Valid UserInputDto dto){
        return userService.save(new User(dto));
    }
}
