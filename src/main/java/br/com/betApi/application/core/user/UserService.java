package br.com.betApi.application.core.user;

import br.com.betApi.domain.model.user.User;
import br.com.betApi.domain.service.users.IUserService;
import br.com.betApi.infrastructure.repository.user.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("Usuário não existe id:"+id));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {

        return null;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
