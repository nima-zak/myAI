package com.Nima.myai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan(basePackages = "com.Nima.myai.entity")
@EnableJpaRepositories(basePackages = "com.Nima.myai.repository")
public class MyAiApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(MyAiApplication.class, args);
	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//				.allowedOrigins("http://localhost:3000")
//				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//				.allowedHeaders("*")
//				.allowCredentials(true);
//	}
}

