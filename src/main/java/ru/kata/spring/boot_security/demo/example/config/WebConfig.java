package ru.kata.spring.boot_security.demo.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.kata.spring.boot_security.demo.services.StringToRoleConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private StringToRoleConverter stringToRoleConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToRoleConverter);
    }
}
