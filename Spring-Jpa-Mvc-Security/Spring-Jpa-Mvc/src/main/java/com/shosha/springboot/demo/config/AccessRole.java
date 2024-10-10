package com.shosha.springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AccessRole {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManagerConfigurer() {
        UserDetails mohamed = User.builder()
                .username("mohamed")
                .password("{noop}shosha1235@@")
                .roles("Admin")
                .build();

        UserDetails karim = User.builder()
                .username("karim")
                .password("{noop}shosha12478@@")
                .roles("Manager")
                .build();

        UserDetails eslam = User.builder()
                .username("eslam")
                .password("{noop}eslam12145@")
                .roles("Employee")
                .build();
        return new InMemoryUserDetailsManager(eslam, karim, mohamed);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/instructors/login")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(LogoutConfigurer::permitAll
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
                );

        return http.build();
    }

}
