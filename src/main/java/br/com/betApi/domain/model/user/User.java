package br.com.betApi.domain.model.user;

import br.com.betApi.application.core.user.dto.UserInputDto;
import br.com.betApi.domain.model.person.Person;
import br.com.betApi.domain.model.user.aggregates.role.Role;
import br.com.betApi.domain.vo.enums.StatusUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "createAt")
    private LocalDateTime createAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusUser status;

    @OneToMany(fetch = FetchType.EAGER,orphanRemoval = true)
    @JoinTable(name = "tb_role_user",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")} )
    private List<Role> roles;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;

    @PrePersist
    public void setCreateAt() {
        this.createAt = LocalDateTime.now();;
    }

    public User(UserInputDto dto) {
        email = dto.email();
        password = dto.password();
        status = dto.status();
        roles = dto.roles().stream().map(Role::new).collect(Collectors.toList());
    }

}
