package pe.edu.upeu.auth_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.auth_server.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
