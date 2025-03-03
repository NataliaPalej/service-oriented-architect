package ie.tus.eng.jpa_lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//localhost:8080/h2-console
// http://localhost:8081/courses (POSTMAN)
@SpringBootApplication
public class JpaLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaLabApplication.class, args);
	}

}
