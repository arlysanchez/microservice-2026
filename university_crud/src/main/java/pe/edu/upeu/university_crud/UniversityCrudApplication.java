package pe.edu.upeu.university_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //habilitar el registro del microservicio en el registry-server
public class UniversityCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityCrudApplication.class, args);
	}

}
