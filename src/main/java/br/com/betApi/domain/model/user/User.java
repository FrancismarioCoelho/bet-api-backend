package br.com.betApi.domain.model.user;

import br.com.betApi.domain.enums.StatusUser;
import br.com.betApi.domain.model.person.Person;
import br.com.betApi.domain.model.user.aggregates.role.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
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

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Role> roles;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public User() {
    }

    public User(String email, String password, LocalDateTime createAt, StatusUser status, List<Role> roles) {
        this.email = email;
        this.password = password;
        this.createAt = createAt;
        this.status = status;
        this.roles = roles;
    }

}
