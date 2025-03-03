package ie.tus.soa.rest_basics.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ie.tus.soa.rest_basics.student.jdbc.StudentJdbcResource;

@Component
public class StudentResource implements CommandLineRunner {
	
	@Autowired
	private StudentJdbcResource studentJdbcResource;
	
	@Override
    public void run(String... args) throws Exception {
		studentJdbcResource.insert(null);
		studentJdbcResource.insert(null);
		studentJdbcResource.insert(null);
		studentJdbcResource.insert(null);
		studentJdbcResource.delete(0);
		studentJdbcResource.findById(1);
		studentJdbcResource.findAll();
	}
	
}
