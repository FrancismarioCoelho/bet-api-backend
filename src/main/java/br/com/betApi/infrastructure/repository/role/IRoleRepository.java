package br.com.betApi.infrastructure.repository.role;

import br.com.betApi.domain.model.user.aggregates.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
}
