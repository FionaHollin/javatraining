package com.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.qa.model","com.qa.services","com.qa.repositories","com.qa.controller"})
@EntityScan("com.qa.model")
public class SpringBootmvcdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootmvcdemoApplication.class, args);
	}
}
