package pe.edu.cibertec.veterinaria;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VeterinariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinariaApplication.class, args);
	}

	@Bean
	public CommandLineRunner ejecutar() {
		return args -> {
			System.out.println("Hola mundo!");
		};
	}
}
