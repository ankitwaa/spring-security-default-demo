package com.example.springsecuritydefaultdemo.config;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Collection;

@Configuration
public class SpringSecurityConfig {

    /**
     * UserDetailService is the contract that needs to be followed to define our own
     * custom implementation.
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails = User.withUsername("ankit").password("ankit").authorities("read").build();
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(userDetails);
        return inMemoryUserDetailsManager;
    }

    /**
     * In Case When we are providing our own implementation of UserDetailService
     * We need to also provide the PasswordEncoder, as This will be required for
     * Encrpt and Decrpt the password so that UserDetailService can validate the
     * user.
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}

