package br.com.betApi.presentation.controller.role;

import br.com.betApi.application.core.role.dto.RoleInputDto;
import br.com.betApi.application.core.role.dto.RoleOutputDto;
import br.com.betApi.domain.model.user.aggregates.role.Role;
import br.com.betApi.domain.service.roles.IRoleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("roles")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @PostMapping
    @Transactional
    public RoleOutputDto save(@RequestBody RoleInputDto dto) {
        return new RoleOutputDto(roleService.save(new Role(dto)));
    }

    @PutMapping
    @Transactional
    public RoleOutputDto update(@RequestBody RoleInputDto dto) {
        return new RoleOutputDto(roleService.update(new Role(dto)));
    }

    @GetMapping(path = "/{id}")
    public RoleOutputDto findById(@RequestParam Long id) {
        return new RoleOutputDto(roleService.findById(id));
    }

    @GetMapping
    private List<RoleOutputDto> findAll() {
        return roleService.findAll().stream().map(RoleOutputDto::new).collect(Collectors.toList());
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    private void delete(@PathVariable Long id){
        roleService.delete(id);
    }

}
