package io.choi.Planit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/users/login", "/users/join", "/users/joinForm",
                    "/css/**", "/js/**", "/images/**"
                ).permitAll() //requestMatchers는 누구나 접근 가능
                .anyRequest().authenticated() //그 외 url은 인증된 사용자만
            )
            .formLogin(form -> form
                .loginPage("/users/loginForm")
                .loginProcessingUrl("/users/login") // 로그인 폼 데이터가 전송될 URL
                .usernameParameter("username")      // 아이디 파라미터 이름
                .passwordParameter("password")      // 비밀번호 파라미터 이름
                .defaultSuccessUrl("/", true)       // 로그인 성공 시 이동할 URL
                .failureUrl("/users/loginForm?error=true") // 로그인 실패 시 이동할 URL (명시적으로 추가)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/users/logout")                
                .logoutSuccessUrl("/users/loginForm?logout=true") // 로그아웃 성공 시 이동할 URL (파라미터 수정)
            );
        return http.build();
    }
}
