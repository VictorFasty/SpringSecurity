package victor.nextrun.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import victor.nextrun.springsecurity.entities.User;

import java.util.UUID;

@Repository
public interface userRepository extends JpaRepository<User, UUID> {
}
