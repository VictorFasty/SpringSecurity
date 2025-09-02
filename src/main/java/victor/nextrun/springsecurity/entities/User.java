package victor.nextrun.springsecurity.entities;

import jakarta.persistence.*;

import javax.management.relation.Role;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID uuid;

    private String username;

    private String password;

    private Set<Role> roles;

}
