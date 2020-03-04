package edu.vescame.simpleSpringSecurity.seed;

import edu.vescame.simpleSpringSecurity.entity.Role;
import edu.vescame.simpleSpringSecurity.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RoleInitializer implements ApplicationListener<ContextRefreshedEvent> {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleInitializer(final RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.roleRepository.saveAll(roles());
    }

    private Iterable<Role> roles() {
        Role admin = new Role("ROLE_ADMIN");
        Role user = new Role("ROLE_USER");

        return Arrays.asList(admin, user);
    }
}
