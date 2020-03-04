package edu.vescame.simpleSpringSecurity.seed;

import edu.vescame.simpleSpringSecurity.entity.User;
import edu.vescame.simpleSpringSecurity.repository.RoleRepository;
import edu.vescame.simpleSpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Arrays;

@Component
public class UserInitializer implements ApplicationListener<ContextRefreshedEvent> {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserInitializer(
            final RoleRepository roleRepository,
            final UserRepository userRepository,
            final PasswordEncoder passwordEncoder
    ) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRole(
                this.roleRepository
                        .findByRoleType("ROLE_ADMIN")
                        .orElseThrow(RuntimeException::new)
        );
        admin.setEmail("admin@email.com");
        admin.setName("admin name");
        admin.setSurname("admin surname");
        admin.setCreatedDate(new Date(new java.util.Date().getTime()));
        admin.setLastModifiedDate(new Date(new java.util.Date().getTime()));

        User user = new User();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("user"));
        user.setRole(
                this.roleRepository
                        .findByRoleType("ROLE_USER")
                        .orElseThrow(RuntimeException::new)
        );
        user.setEmail("user@email.com");
        user.setName("user name");
        user.setSurname("user surname");
        user.setCreatedDate(new Date(new java.util.Date().getTime()));
        user.setLastModifiedDate(new Date(new java.util.Date().getTime()));

        this.userRepository.saveAll(Arrays.asList(admin, user));
    }
}
