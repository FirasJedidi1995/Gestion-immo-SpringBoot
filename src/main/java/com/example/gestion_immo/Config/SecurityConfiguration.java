package com.example.gestion_immo.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.example.gestion_immo.Entities.Permission.*;
import static com.example.gestion_immo.Entities.Role.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authentificationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/register","/api/v1/auth/authenticate","/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html", "/webjars/**","http://localhost:3000")
                .permitAll()

// Securiser les differents endpoints

                .requestMatchers("api/region/**").hasAnyRole(Admin.name(), USER.name())
                .requestMatchers(HttpMethod.GET,"api/region/**").hasAnyAuthority(Admin_READ.name(),USER_READ.name())
                .requestMatchers(HttpMethod.POST,"api/region/**").hasAnyAuthority(Admin_CREATE.name(),USER_CREATE.name())
                .requestMatchers(HttpMethod.PUT,"api/region/**").hasAnyAuthority(Admin_UPDATE.name(),USER_UPDATE.name())
                .requestMatchers(HttpMethod.DELETE,"api/region/**").hasAnyAuthority(Admin_DELETE.name(),USER_DELETE.name())


                .requestMatchers("api/options/**").hasAnyRole(Admin.name(), USER.name())
                .requestMatchers(HttpMethod.GET,"api/options/**").hasAnyAuthority(Admin_READ.name(),USER_READ.name())
                .requestMatchers(HttpMethod.POST,"api/options/**").hasAnyAuthority(Admin_CREATE.name(),USER_CREATE.name())
                .requestMatchers(HttpMethod.PUT,"api/options/**").hasAnyAuthority(Admin_UPDATE.name(),USER_UPDATE.name())
                .requestMatchers(HttpMethod.DELETE,"api/options/**").hasAnyAuthority(Admin_DELETE.name(),USER_DELETE.name())


                .requestMatchers("api/categorie/**").hasAnyRole(Admin.name(), USER.name())
                .requestMatchers(HttpMethod.GET,"api/categorie/**").hasAnyAuthority(Admin_READ.name(),USER_READ.name())
                .requestMatchers(HttpMethod.POST,"api/categorie/**").hasAnyAuthority(Admin_CREATE.name(),USER_CREATE.name())
                .requestMatchers(HttpMethod.PUT,"api/categorie/**").hasAnyAuthority(Admin_UPDATE.name(),USER_UPDATE.name())
                .requestMatchers(HttpMethod.DELETE,"api/categorie/**").hasAnyAuthority(Admin_DELETE.name(),USER_DELETE.name())


                .requestMatchers("api/ville/**").hasAnyRole(Admin.name(), USER.name())
                .requestMatchers(HttpMethod.GET,"api/ville/**").hasAnyAuthority(Admin_READ.name(),USER_READ.name())
                .requestMatchers(HttpMethod.POST,"api/ville/**").hasAnyAuthority(Admin_CREATE.name(),USER_CREATE.name())
                .requestMatchers(HttpMethod.PUT,"api/ville/**").hasAnyAuthority(Admin_UPDATE.name(),USER_UPDATE.name())
                .requestMatchers(HttpMethod.DELETE,"api/ville/**").hasAnyAuthority(Admin_DELETE.name(),USER_DELETE.name())







                .requestMatchers("/api/user/**").hasAnyRole(Admin.name(), USER.name())
                .requestMatchers(HttpMethod.GET,"/api/user/**").hasAnyAuthority(Admin_READ.name(),USER_READ.name())
                .requestMatchers(HttpMethod.POST,"/api/user/**").hasAnyAuthority(Admin_CREATE.name(),USER_CREATE.name())
                .requestMatchers(HttpMethod.PUT,"/api/user/**").hasAnyAuthority(Admin_UPDATE.name(),USER_UPDATE.name())
                .requestMatchers(HttpMethod.DELETE,"/api/user/**").hasAnyAuthority(Admin_DELETE.name(),USER_DELETE.name())



                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authentificationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }



}
