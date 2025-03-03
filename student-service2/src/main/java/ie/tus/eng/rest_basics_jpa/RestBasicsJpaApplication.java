package ie.tus.eng.rest_basics_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// http://localhost:8080/students
@SpringBootApplication
@EnableFeignClients(basePackages = "ie.tus.eng.rest_basics_jpa.course")
public class RestBasicsJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestBasicsJpaApplication.class, args);
	}
}
