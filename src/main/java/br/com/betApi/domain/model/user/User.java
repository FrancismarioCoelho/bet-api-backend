package br.com.betApi.domain.model.user;

import br.com.betApi.domain.model.user.aggregates.Role;
import br.com.betApi.domain.objectValues.enums.StatusUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "createAt")
    private LocalDateTime createAt;

    @Column(name = "status")
    private StatusUser status;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
