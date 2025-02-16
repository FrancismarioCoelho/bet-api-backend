package br.com.betApi.domain.model.user.aggregates.role;


import br.com.betApi.application.core.role.dto.request.RoleRequestDTO;
import br.com.betApi.application.core.role.dto.request.RoleRequestSimpleDTO;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "tb_role")
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Role() {
    }

    public Role(Role role) {
         id = role.getId();
         name = role.getName();
         description = role.getDescription();
    }

    public Role(RoleRequestSimpleDTO dto) {
        this.id = dto.id();
    }

    public Role(RoleRequestDTO dto) {
         id = dto.id();
         name = dto.name();
         description = dto.description();
    }

}
