package com.cinema.security;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                // CSRF 보안 해제()
                .csrf(CsrfConfigurer::disable) // :: 는 메서드 참조 연산자로 람다식을 간단하게 표현
                // 기본 HTTP 인증방식 비활성
                //.httpBasic(HttpBasicConfigurer::disable)
                // 기본 form 로그인 설정
                .formLogin(login -> login
                        .loginPage("/user/login")
                        .defaultSuccessUrl("/")
                        .failureUrl("/user/login?success=100")
                        .usernameParameter("uid")
                        .passwordParameter("pass"))
                // 로그아웃 설정
                .logout(logout -> logout
                        .logoutUrl("/user/logout")
                        .logoutSuccessUrl("/"))


                // 토큰방식으로 인증처리하기 때문에 세션을 사용안하게 STATELESS 설정
                //.sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 인가 설정
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers("/manager/**").hasAnyAuthority("ADMIN", "MANAGER")
                        .requestMatchers("/guest/**").permitAll()
                        .requestMatchers("/user/**").permitAll()
                        .requestMatchers("/**").permitAll()
                        .requestMatchers("/css/**", "/images/**", "/js/**").permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}