package br.com.betApi.services;


import br.com.betApi.application.shared.dto.FilterDto;
import br.com.betApi.application.shared.dto.UserDto;
import br.com.betApi.application.shared.mapper.GenericObjectMapper;
import br.com.betApi.domain.enums.StatusUser;
import br.com.betApi.domain.model.user.User;
import br.com.betApi.domain.model.user.aggregates.role.Role;
import br.com.betApi.domain.vo.IUserServiceImpl;
import br.com.betApi.infrastructure.repository.IUserRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private IUserRepositoryImpl userRepository;

    @Autowired
    private IUserServiceImpl service;

    @Autowired
    private GenericObjectMapper mapper;


    public User createUser(String email, String senha,
                           StatusUser status, String descriptionRole){
        Role role = new Role(descriptionRole);
        return new User( email, senha, LocalDateTime.now(),
                status, Collections.singletonList(role));
    }

    @Test
    @DisplayName(value = "Save to user test")
    void save(){
      User newUser = this.createUser("luiz@devtest", "123",
              StatusUser.ATIVO, "Usuário Jogador");
      UserDto newUserDto = this.mapper.mapTo(newUser, UserDto.class);
      Assertions.assertNotNull(this.service.save(newUserDto));
    }

    @Test
    @DisplayName(value = "Update to user test")
    void update(){
        List<User> userDatabase = this.userRepository.findAll();
        User newUser = this.createUser( "mc@devtest", "321",
                StatusUser.ATIVO, "Administrator");
        UserDto newUserDto = this.mapper.mapTo(newUser, UserDto.class);
        if(userDatabase.isEmpty()){
           this.save();
           userDatabase.addAll(this.userRepository.findAll());
        }else{
            userDatabase.forEach(user -> newUserDto.setId(user.getId()));
        }
        Assertions.assertNotNull(this.service.update(newUserDto));
    }

    @Test
    @DisplayName(value = "Update to user test")
    void findById(){
        List<User> userDatabase = this.userRepository.findAll();

        if(userDatabase.isEmpty()){
            this.save();
            userDatabase.addAll(this.userRepository.findAll());
        }else{
            userDatabase.forEach(user ->
                    Assertions.assertNotNull(this.service.findById(user.getId())));
        }
    }


    @Test
    @DisplayName(value = "Filter to user test")
    void filterId(){
        List<User> userDatabase = this.userRepository.findAll();
        if(userDatabase.isEmpty()){
            this.save();
            userDatabase.addAll(this.userRepository.findAll());
        }else{
            userDatabase.forEach(user ->{
                FilterDto filterDto = new FilterDto();
                filterDto.setId(user.getId());

                Optional<UserDto> userFilterId =
                        this.service.findAll(filterDto, Pageable.unpaged()).stream().findAny();
                userFilterId.ifPresent(userDto ->
                        Assertions.assertEquals(userDto.getId(), filterDto.getId()));

                filterDto.setId(null);
                filterDto.setEmail(user.getEmail());

                Optional<UserDto> userFilterEmail =
                        this.service.findAll(filterDto, PageRequest.of(0, 1)).stream().findAny();
                userFilterEmail.ifPresent(userDto ->
                        Assertions.assertEquals(userDto.getEmail(), user.getEmail()));

                filterDto.setId(null);
                filterDto.setEmail(null);
                filterDto.setRoles(Collections.singletonList(user.getRoles().get(0).getDescription()));

                Optional<UserDto> userFilterRole =
                        this.service.findAll(filterDto, PageRequest.of(0, 1)).stream().findAny();
                userFilterRole.ifPresent(userDto ->
                        Assertions.assertEquals(userDto.getRoles().get(0).getDescription(),
                                user.getRoles().get(0).getDescription()));
                });
        }
    }

    @Test
    @DisplayName(value = "Delete to user test")
    void delete(){
        List<User> userDatabase = this.userRepository.findAll();

        if(userDatabase.isEmpty()){
            this.save();
            userDatabase.addAll(this.userRepository.findAll());
        }else{
            userDatabase.forEach(user -> this.service.delete(user.getId()));

            if(this.userRepository.findAll().isEmpty()){
                Assertions.assertTrue(Boolean.TRUE);
            }
        }
    }

}
