package ie.tus.eng.jpa_lab.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ie.tus.eng.jpa_lab.course.jpa.CourseJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private CourseJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		// Add content to the table
		repository.save(new Course(1, "Course 1", "22"));
		repository.save(new Course(2, "Course 2", "33"));
		repository.save(new Course(3, "Course 3", "44"));
		repository.save(new Course(4, "Course 4", "55"));
		repository.save(new Course(5, "Course 5", "66"));
		repository.save(new Course(6, "Course 6", "77"));
	
		// Delete id=2
		System.out.println("Database table ready.");
		System.out.println();
//		repository.deleteById(2l); // add "l" for "long"
//		System.out.println("Course deleted successfully.");
//		System.out.println();
//		System.out.println(repository.findById(4l));
//		System.out.println();
//		System.out.println(repository.findAll());
//		System.out.println();
//		System.out.println("Course by code 1: \n" + repository.findByCode("22"));
//		System.out.println();
//		System.out.println("Course Name: \n" + repository.findByName("Course 1"));
	}

}
