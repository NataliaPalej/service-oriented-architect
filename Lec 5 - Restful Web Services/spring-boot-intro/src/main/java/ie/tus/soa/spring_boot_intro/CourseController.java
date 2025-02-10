// The below class is Spring MVC - Spring module that simplifies building web apps and REST APIs
package ie.tus.soa.spring_boot_intro;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	// localhost:8080/courses 
	@GetMapping("/courses")
	public List<Course> retrieveAllCourses(){
		return Arrays.asList(
				new Course(1, "Databases", "Denis"),
				new Course(2, "Software Development", "Declan"),
				new Course(3, "Maths", "Mark")
				);
				
	}

}
