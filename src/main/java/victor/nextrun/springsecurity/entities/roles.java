package victor.nextrun.springsecurity.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_roles")
public class roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleid;

    private String name;


}
