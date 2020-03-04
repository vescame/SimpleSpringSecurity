package edu.vescame.simpleSpringSecurity.security;

import edu.vescame.simpleSpringSecurity.security.constant.Resources;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(Resources.RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .and()
                .authorizeRequests()
//                    .anyRequest().fullyAuthenticated() // unable to use antMatchers after anyRequest()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll();
    }
}
