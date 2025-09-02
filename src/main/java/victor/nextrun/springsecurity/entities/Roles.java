package victor.nextrun.springsecurity.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_roles")
@Data
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleid;

    private String name;


}
