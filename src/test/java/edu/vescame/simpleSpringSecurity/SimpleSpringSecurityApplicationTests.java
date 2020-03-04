package edu.vescame.simpleSpringSecurity;

import edu.vescame.simpleSpringSecurity.entity.User;
import edu.vescame.simpleSpringSecurity.repository.RoleRepository;
import edu.vescame.simpleSpringSecurity.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class SimpleSpringSecurityApplicationTests {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public SimpleSpringSecurityApplicationTests(
            final UserRepository userRepository,
            final RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setUsername("vescame");
        user.setPassword("passwd");
        user.setRole(
                this.roleRepository
                        .findByRoleType("ROLE_ADMIN")
                        .orElseThrow(RuntimeException::new)
        );

        this.userRepository.save(user);

        User user1 = new User();
        user1.setUsername("vescame1");
        user1.setPassword("passwd1");
        user1.setRole(
                this.roleRepository
                        .findByRoleType("ROLE_ADMIN")
                        .orElseThrow(RuntimeException::new)
        );

        this.userRepository.save(user1);

        Optional<User> retrvdUser = this.userRepository.findByUsername("vescame");
    }
}
