package br.com.betApi.domain.model.user.aggregates.role;


import br.com.betApi.application.core.role.dto.RoleInputDto;
import br.com.betApi.domain.model.user.User;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "tb_role")
@NoArgsConstructor
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;


    public Role(RoleInputDto dto) {
        this.id = dto.id();
        this.description = dto.description();
    }

    public Role(Role role) {
        this.id = role.getId();
        this.description = role.getDescription();
    }

}
