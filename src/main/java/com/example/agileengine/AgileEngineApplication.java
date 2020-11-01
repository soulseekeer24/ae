package com.example.agileengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableScheduling
@SpringBootApplication
@EnableWebMvc
public class AgileEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgileEngineApplication.class, args);
	}


}
