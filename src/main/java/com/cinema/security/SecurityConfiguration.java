package com.cinema.security;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Log4j2
@Configuration
public class SecurityConfiguration implements WebMvcConfigurer {

    @Autowired
    private SecurityUserService securityUserService;

    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${upload.path.files}")
    private String files;

    @Value("${upload.path.thumbs}")
    private String thumbs;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/files/**")
                .addResourceLocations(resourceLoader.getResource(files));

        registry.addResourceHandler("/thumbs/**")
                .addResourceLocations(resourceLoader.getResource("file:" + thumbs));

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 사이트 위변조 방지 비활성
                .csrf(CsrfConfigurer::disable)
                // 폼 로그인 설정
                .formLogin(config -> config
                        .loginPage("/member/login")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/member/login?success=100")
                        .usernameParameter("uid")
                        .passwordParameter("pass"))

                // 자동로그인 설정
                .rememberMe(config -> config.userDetailsService(securityUserService)
                        .rememberMeParameter("rememberMe")
                        .key("uniqueAndSecret")
                        .tokenValiditySeconds(86400))

                // 로그아웃 설정
                .logout(config -> config
                        .logoutUrl("/member/logout")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutSuccessUrl("/index?success=300"))

                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                        .requestMatchers("/member/**").permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/**").permitAll()
                        .requestMatchers("/vendor/**", "/js/**", "/dist/**", "/data/**", "/less/**", "/css/**").permitAll());

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}