package br.com.betApi.presentation.controller.role;

import br.com.betApi.application.core.role.dto.request.RoleRequestDTO;
import br.com.betApi.application.core.role.dto.request.RoleRequestSimpleDTO;
import br.com.betApi.application.core.role.dto.response.RoleResponseDTO;
import br.com.betApi.domain.model.user.aggregates.role.Role;
import br.com.betApi.domain.service.roles.IRoleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @PostMapping
    @Transactional
    public RoleResponseDTO save(@RequestBody RoleRequestDTO dto) {
        return new RoleResponseDTO(roleService.save(new Role(dto)));
    }

    @PutMapping
    @Transactional
    public RoleResponseDTO update(@RequestBody RoleRequestDTO dto) {
        return new RoleResponseDTO(roleService.update(new Role(dto)));
    }

    @GetMapping(path = "/{id}")
    public RoleResponseDTO findById(@PathVariable Long id) {
        return new RoleResponseDTO(roleService.findById(id));
    }

    @GetMapping
    public List<RoleResponseDTO> findAll() {
        return roleService.findAll().stream().map(RoleResponseDTO::new).collect(Collectors.toList());
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        roleService.delete(id);
    }

}
