package ru.lazarev.lesson11.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class.getName());

    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2y$12$FY4epAuELMAKfzVdTBFjcOJ0PUaBDxjGOF3wQWEuZ7YcG57AE2g76")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2y$12$FY4epAuELMAKfzVdTBFjcOJ0PUaBDxjGOF3wQWEuZ7YcG57AE2g76")
                .roles("USER", "MANAGER", "ADMIN")
                .build();
        UserDetails manager = User.builder()
                .username("manager")
                .password("{bcrypt}$2y$12$FY4epAuELMAKfzVdTBFjcOJ0PUaBDxjGOF3wQWEuZ7YcG57AE2g76")
                .roles("USER", "MANAGER")
                .build();
        return new InMemoryUserDetailsManager(user, admin, manager);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("In-Memory Security Configuration");
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/h2/**").authenticated()
                .antMatchers("/set.html/**").hasRole("MANAGER")
                .antMatchers("/users.html/**").hasRole("ADMIN")
                .and()
                .formLogin();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
