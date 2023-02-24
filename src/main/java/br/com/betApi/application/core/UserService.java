package br.com.betApi.application.core;

import br.com.betApi.application.shared.dto.FilterDto;
import br.com.betApi.application.shared.dto.UserDto;
import br.com.betApi.application.shared.function.Functions;
import br.com.betApi.application.shared.mapper.GenericObjectMapper;
import br.com.betApi.domain.model.user.User;
import br.com.betApi.domain.vo.IUserServiceImpl;
import br.com.betApi.infrastructure.repository.IUserRepositoryImpl;
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
    public UserDto findById(Long id) {
        User userDatabase = this.userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Entity not found!"));
        return this.mapper.mapTo(userDatabase, UserDto.class);
    }

    @Override
    public Page<UserDto> findAll(FilterDto filterDto, Pageable pageable) {
        Page<User> userDatabase =
                this.userRepository.filter(
                        filterDto.getId(),
                        filterDto.getEmail(),
                        filterDto.getRoles(),
                        pageable);
        return this.mapper.mapToPageable(userDatabase, UserDto.class);
    }


    @Override
    public UserDto save(UserDto userDto) {
     return  Functions.acceptTrue(Functions.notNull(userDto), ()-> {
            User newUser = this.mapper.mapTo(userDto, User.class);
            return this.mapper.mapTo(this.userRepository.save(newUser), UserDto.class);
        }, ()-> { throw  new EntityNotFoundException("Error to save Entity");});
    }

    @Override
    public UserDto update(UserDto userDto) {
        return  Functions.acceptTrue(Functions.notNull(userDto), ()-> {
            User userDatabase = this.mapper.mapTo(this.findById(userDto.getId()), User.class);
            User userUpdate = this.mapper.mapTo(userDto, User.class);
            BeanUtils.copyProperties(userUpdate,userDatabase, "id" );
            return this.mapper.mapTo(this.userRepository.save(userDatabase), UserDto.class);
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
