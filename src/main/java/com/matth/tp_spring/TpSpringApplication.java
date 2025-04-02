package com.matth.tp_spring;

import com.matth.tp_spring.service.RegistrationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class TpSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(TpSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner register(RegistrationService registrationService) {
		return args -> registrationService.registerToArena();
	}
}
