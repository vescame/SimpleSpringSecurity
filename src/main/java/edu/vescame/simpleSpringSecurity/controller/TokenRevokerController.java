package edu.vescame.simpleSpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("v1")
public class TokenRevokerController {
    @Resource(name = "tokenServices")
    private ConsumerTokenServices tokenServices;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE, value = "logout")
    public void revokeToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        String bearerPrefix = "Bearer";
        if (authorization.contains(bearerPrefix) ||
                authorization.contains(bearerPrefix.toLowerCase())) {
            String tokenId = authorization.substring(bearerPrefix.length() + 1);
            tokenServices.revokeToken(tokenId);
        }
    }
}
