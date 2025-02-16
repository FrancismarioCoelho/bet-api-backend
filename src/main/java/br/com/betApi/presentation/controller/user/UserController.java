package br.com.betApi.presentation.controller.user;

import br.com.betApi.application.core.user.dto.request.UserRequestDTO;
import br.com.betApi.application.core.user.dto.response.UserResponseDTO;
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
    private IUserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity<UserResponseDTO> save(@Valid @RequestBody UserRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(new UserResponseDTO(userService.save(new User(dto))));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UserResponseDTO> update(@Valid @RequestBody UserRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(new UserResponseDTO(userService.update(new User(dto))));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(new UserResponseDTO(userService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll(Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.findAll().stream().map(UserResponseDTO::new).collect(Collectors.toList()));
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }


}
