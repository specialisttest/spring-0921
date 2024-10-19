package ru.specialist.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"ru.specialist.controllers", 
		"ru.specialist.models", "ru.specialist.dao"})
@EnableWebMvc
public class ApplicationConfig {
	

}
