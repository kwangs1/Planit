package io.choi.Planit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/users/**",
                    "/css/**", "/js/**", "/images/**"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/users/loginForm")
                .loginProcessingUrl("/users/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/users/logout")
                .logoutSuccessUrl("/users/login?loginout")
            ); 
        return http.build();
    }
}
