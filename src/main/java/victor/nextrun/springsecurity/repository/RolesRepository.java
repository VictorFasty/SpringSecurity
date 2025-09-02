package victor.nextrun.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import victor.nextrun.springsecurity.entities.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
}
