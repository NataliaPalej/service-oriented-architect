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
		repository.save(new Course(1, "Class 1", "Lecture 1"));
		repository.save(new Course(2, "Class 2", "Lecture 2"));
		repository.save(new Course(3, "Class 3", "Lecture 3"));
		repository.save(new Course(4, "Class 4", "Lecture 4"));
		repository.save(new Course(5, "Class 5", "Lecture 5"));
		repository.save(new Course(6, "Class 6", "Lecture 6"));
	
		// Delete id=2
		System.out.println("Database table ready.");
		System.out.println();
		repository.deleteById(2l); // add "l" for "long"
		System.out.println("User deleted successfully.");
		System.out.println();
		System.out.println(repository.findById(4l));
		System.out.println();
		System.out.println(repository.findAll());
		System.out.println();
		System.out.println("Course by Lecturer 1: \n" + repository.findByAuthor("Lecture 1"));
		System.out.println();
		System.out.println("Course Name: \n" + repository.findByName("Class 5"));
	}

}
