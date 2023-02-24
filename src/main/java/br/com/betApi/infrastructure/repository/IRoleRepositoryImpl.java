package br.com.betApi.infrastructure.repository;

import br.com.betApi.domain.model.user.aggregates.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepositoryImpl extends JpaRepository<Role, Long> {

}
