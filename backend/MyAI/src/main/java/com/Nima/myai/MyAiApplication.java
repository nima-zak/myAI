package com.Nima.myai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.Nima.myai.entity")
@EnableJpaRepositories(basePackages = "com.Nima.myai.repository")
public class MyAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAiApplication.class, args);
	}
}
