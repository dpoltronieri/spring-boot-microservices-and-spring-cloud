package com.dpoltronieri.photoapp.api.users.photo_app_api_users.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.dpoltronieri.photoapp.api.users.photo_app_api_users.service.UsersService;

@Configuration
@EnableWebSecurity
public class WebSecurity {

    @Autowired
    private Environment environment;
    @Autowired
    private UsersService usersService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @SuppressWarnings("removal")
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception{

        // Configure authenticationManagerBuilder
        AuthenticationManagerBuilder authenticationManagerBuilder =
            http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder.userDetailsService(usersService)
            .passwordEncoder(bCryptPasswordEncoder);

        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers(HttpMethod.POST, "/users").access(new WebExpressionAuthorizationManager("hasIpAddress('"+ environment.getProperty("gateway.ip") +"')"))
                .requestMatchers(HttpMethod.GET, "/users/**").permitAll()
                .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll())
                .addFilter(new AuthenticationFilter(usersService, environment, authenticationManager))
                .authenticationManager(authenticationManager)
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.headers(headers -> headers.frameOptions().disable());

        return http.build();
    }


    // Antigo:
    // http.csrf().disable();
    // http.authorizeHttpRequests()
    // .requestMatchers(HttpMethod.POST, "/users").permitAll()
    // .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
    // .and()
    // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    // http.headers().frameOptions().disable();
}
