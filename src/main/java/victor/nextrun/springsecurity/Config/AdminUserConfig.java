package victor.nextrun.springsecurity.Config;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import victor.nextrun.springsecurity.entities.Roles;
import victor.nextrun.springsecurity.entities.User;
import victor.nextrun.springsecurity.repository.RolesRepository;
import victor.nextrun.springsecurity.repository.UserRepository;
import java.util.Set;

@AllArgsConstructor
public class AdminUserConfig implements CommandLineRunner {

    private RolesRepository rolesRepository;
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        var roleAdmin = rolesRepository.findByName(Roles.Values.ADMIN.name());

        var userAdmin = userRepository.findByUsername("admin");

        userAdmin.ifPresentOrElse(
                user -> {
                    System.out.println("admin ja existe");
                },
                () -> {
                    var user = new User();
                    user.setUsername("admin");
                    user.setPassword(passwordEncoder.encode("123"));
                    user.setRoles(Set.of(roleAdmin));
                    userRepository.save(user);
                }
        );
    }
}