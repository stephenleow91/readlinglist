package com.example.readinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.controller", "com.example.service" })
@EnableJpaRepositories("com.example.repository")
@EntityScan("com.example.domain")
public class ReadinglistApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadinglistApplication.class, args);
	}

}
