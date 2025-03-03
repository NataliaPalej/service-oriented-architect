package ie.tus.eng.jdbc_lab.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ie.tus.eng.jdbc_lab.course.jdbc.CourseJdbcRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    
    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "WebDev", "Enda"));
        repository.insert(new Course(2, "Databases", "Lecturer 2"));
        repository.insert(new Course(3, "Security", "Lecturer 3"));
        repository.insert(new Course(4, "Project", "Lecturer 4"));
        System.out.println("\nCourse inserted successfully!");
        repository.delete(2);
        System.out.println("\nCourse deleted successfully!");
        System.out.println();
        System.out.println(repository.findById(4));
        System.out.println();
        System.out.println(repository.findAll());
        System.out.println();
    }
}
