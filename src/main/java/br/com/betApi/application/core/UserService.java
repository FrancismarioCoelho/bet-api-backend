package br.com.betApi.application.core;

import br.com.betApi.application.shared.dto.FilterDto;
import br.com.betApi.application.shared.dto.UserDto;
import br.com.betApi.application.shared.function.Functions;
import br.com.betApi.application.shared.mapper.GenericObjectMapper;
import br.com.betApi.application.shared.util.Util;
import br.com.betApi.domain.model.user.User;
import br.com.betApi.domain.vo.IUserServiceImpl;
import br.com.betApi.infrastructure.repository.user.IUserRepositoryImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserServiceImpl {

    @Autowired
    private GenericObjectMapper mapper;

    @Autowired
    private IUserRepositoryImpl userRepository;


    @Override
    public UserDto findById(Long id) {User userDatabase = this.userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Entity not found!"));
        return Util.mapTo(userDatabase, new UserDto());
    }

    @Override
    public Page<UserDto> findAll(FilterDto filterDto, Pageable pageable) {
        Page<User> userDatabase =
                this.userRepository.filter(
                        filterDto.getId(),
                        filterDto.getEmail(),
                        filterDto.getRoles(),
                        pageable);
        return Util.mapToPageable(userDatabase, new UserDto());
    }


    @Override
    public UserDto save(UserDto userDto) {
     return  Functions.acceptTrue(Functions.notNull(userDto), ()-> {
            User newUser = this.mapper.mapTo(userDto, User.class);
            return Util.mapTo(this.userRepository.save(newUser), new UserDto());
        }, ()-> { throw  new EntityNotFoundException("Error to save Entity");});
    }

    @Override
    public UserDto update(UserDto userDto) {
        return  Functions.acceptTrue(Functions.notNull(userDto), ()-> {
            User userDatabase = Util.mapTo(this.findById(userDto.getId()), new User());
            User userUpdate = Util.mapTo(userDto, new User());
            BeanUtils.copyProperties(userUpdate,userDatabase, "id" );
            User userSaved = this.userRepository.save(userDatabase);
            return Util.mapTo(userSaved, new UserDto());
        }, ()-> { throw  new EntityNotFoundException("Erro to update Entity");});
    }

    @Override
    public void delete(Long id) {
       try{
           this.userRepository.deleteById(id);
       }catch (Exception e){
           throw  new EntityNotFoundException("Erro to delete Entity" + e);
       }
    }
}
