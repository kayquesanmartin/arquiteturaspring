package io.github.kayquesanmartin.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication // Importante para o contexto de execução da aplicação
public class Application {

	// Só mexemos quando é realmente necessário.
	public static void main(String[] args) {
		// SpringApplication.run(Application.class, args);

		// Importante passar o Application.class
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
		
		builder.bannerMode(Banner.Mode.OFF);
		builder.profiles("producao", "dev");

		builder.run(args); // Args são importantes para nossa aplicação	

		// Contexto da aplicação já iniciada
		ConfigurableApplicationContext applicationContext = builder.context();
		// var userRepository = applicationContext.getBean("userRepository");

		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String applicationName = environment.getProperty("spring.application.name");
		System.out.println(applicationName);
	}

}