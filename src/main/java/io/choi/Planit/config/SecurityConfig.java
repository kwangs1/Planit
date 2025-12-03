package io.choi.Planit.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            HttpSecurity http,
            UserDetailsService userDetailsService,
            PasswordEncoder encoder
    ) throws Exception {
        AuthenticationManagerBuilder builder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        builder.userDetailsService(userDetailsService)
            .passwordEncoder(encoder);

        return builder.build();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
        repo.setDataSource(dataSource);
        return repo;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> 
                auth
                    .requestMatchers(
                        "/users/login", "/users/join", "/users/joinForm", 
                        "/users/findByUsers", "/users/passWordReset",
                        "/css/**", "/js/**", "/images/**"
                    ).permitAll() //requestMatchers는 누구나 접근 가능
                    .anyRequest().authenticated() //그 외 url은 인증된 사용자만
            )
            .formLogin(form -> 
                form
                    .loginPage("/users/loginForm")
                    .loginProcessingUrl("/users/login") // 로그인 폼 데이터가 전송될 URL
                    .usernameParameter("sabun")      // 아이디 파라미터 이름
                    .passwordParameter("password")      // 비밀번호 파라미터 이름
                    .defaultSuccessUrl("/", true)       // 로그인 성공 시 이동할 URL
                    .failureUrl("/users/loginForm?error=true") // 로그인 실패 시 이동할 URL (명시적으로 추가)
                    .permitAll()
            )
            .rememberMe(remember -> 
                remember
                    .key("SUPER_SECRET_REMEMBER_ME_KEY")
                    .rememberMeParameter("remember-me")
                    .tokenValiditySeconds(60 * 60 * 24 * 14)
                    .tokenRepository(persistentTokenRepository())
                    .userDetailsService(userDetailsService)
            )
            .logout(logout -> 
                logout
                    .logoutUrl("/users/logout")                
                    .logoutSuccessUrl("/users/loginForm?logout=true") // 로그아웃 성공 시 이동할 URL (파라미터 수정)
            );
        return http.build();
    }
}
