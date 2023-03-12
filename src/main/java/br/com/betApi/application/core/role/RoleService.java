package br.com.betApi.application.core.role;

import br.com.betApi.domain.model.user.aggregates.role.Role;
import br.com.betApi.domain.service.roles.IRoleService;
import br.com.betApi.infrastructure.repository.role.IRoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role) {
        Role roleSave = findById(role.getId());
        BeanUtils.copyProperties(role,roleSave);
        return roleRepository.save(role);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role não existe id:"+id));
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
