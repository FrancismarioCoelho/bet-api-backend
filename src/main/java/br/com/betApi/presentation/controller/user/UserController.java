package br.com.betApi.presentation.controller.user;

import br.com.betApi.application.core.user.UserService;
import br.com.betApi.application.core.user.dto.UserInputDto;
import br.com.betApi.application.core.user.dto.UserOutputDto;
import br.com.betApi.domain.model.user.User;
import br.com.betApi.domain.service.users.IUserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    private ResponseEntity<UserOutputDto> save(@RequestBody  UserInputDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(new UserOutputDto(userService.save(new User(dto))));
    }

    @PutMapping
    @Transactional
    private ResponseEntity<UserOutputDto> update(@RequestBody @Valid UserInputDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(new UserOutputDto(userService.update(new User(dto))));
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity<UserOutputDto>  findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(new UserOutputDto(userService.findById(id)));
    }

    @GetMapping
    private ResponseEntity<List<UserOutputDto>> findAll(Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.findAll().stream().map(UserOutputDto::new).collect(Collectors.toList()));
    }
    @DeleteMapping(path = "/{id}")
    @Transactional
    private void delete(@PathVariable Long id){
        userService.delete(id);
    }

}
