package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"com.resume.controller", "com.resume.service" ,"com.resume.dao"})
@EntityScan("com.resume.model")
@EnableJpaRepositories("com.resume.repository")
public class SpringBoot09Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot09Application.class, args);
	}
}
