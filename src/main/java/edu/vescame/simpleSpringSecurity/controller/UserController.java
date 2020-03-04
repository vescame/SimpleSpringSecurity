package edu.vescame.simpleSpringSecurity.controller;

import edu.vescame.simpleSpringSecurity.entity.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class UserController {

    @GetMapping(value = {"hello"})
    public String hello() {
        return "hello from hello";
    }

    @Secured({"ROLE_USER"})
    @GetMapping(value = {"user"})
    public String helloForAuthorized() {
        return "hello, you're authorized";
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping(value = {"admin"})
    public User admin() {
        return (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
