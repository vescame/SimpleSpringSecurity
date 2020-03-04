package edu.vescame.simpleSpringSecurity.service;

import edu.vescame.simpleSpringSecurity.entity.User;
import edu.vescame.simpleSpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public void addUser(User user) {
        this.userRepository.save(user);
    }

    public Optional<User> getUserByCredentials(final String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        Optional<User> user = this.getUserByCredentials(username);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return user.get();
    }
}
