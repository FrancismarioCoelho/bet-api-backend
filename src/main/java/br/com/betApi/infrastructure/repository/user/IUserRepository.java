package br.com.betApi.infrastructure.repository.user;

import br.com.betApi.domain.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query("FROM User u" +
            " WHERE (:id IS NULL OR :id = 0 OR u.id = :id) " +
            " AND (:email IS NULL OR :email = '' OR LOWER(u.email) LIKE LOWER(CONCAT('%', :email, '%')))"+
            "AND (COALESCE(null, :roles) IS NULL OR EXISTS(FROM Role r WHERE r.user.id = u.id AND r.description IN(:roles))) "
           )
    Page<User> filter(
            @Param("id") Long id,
            @Param("email") String email,
            @Param("roles") List<String> roles,
            Pageable pageable);
}
