package com.cinema.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class SecurityConfig implements WebMvcConfigurer{

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/thumbs/**")
                .addResourceLocations(resourceLoader.getResource("file:thumbs/"));
    }
}
