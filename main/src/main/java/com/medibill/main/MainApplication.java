package com.medibill.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(scanBasePackages = {"com.medibill.main.loginusers", "com.medibill.roleModule"})
@EnableWebSecurity
@ComponentScan(basePackages = {"com.medibill.main.loginusers", "com.medibill.roleModule"})
@EntityScan(basePackages = {"com.medibill.main.loginusers", "com.medibill.roleModule"})
@EnableJpaRepositories(basePackages = {"com.medibill.roleModule", "com.medibill.main"})
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
