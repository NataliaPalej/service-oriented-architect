package ie.tus.eng.jpa_lab.course;

import java.net.URI;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ie.tus.eng.jpa_lab.course.jpa.CourseJpaRepository;

@RestController
public class CourseResources {
	private CourseJpaRepository repository;
	
	@Autowired
	public CourseResources(CourseJpaRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/courses")
	public List<Course> retrieveAllCourses(){
		return repository.findAll();
	}
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> retrieveCourse(@PathVariable long id){
		Optional<Course> course = repository.findById(id);
		
		if(course.isEmpty()) {
			System.out.println("Course not found.");
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(course.get());
		}
	}
	
	@DeleteMapping
    public ResponseEntity<Void> deleteAllCourses() {
		repository.deleteAll();
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
    	Course savedCourse = repository.save(course);
        URI location = URI.create("/courses/" + savedCourse.getId());
        return ResponseEntity.created(location).body(savedCourse); // 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> editCourse(@PathVariable long courseID, @RequestBody Course updatedCourse) {
        Optional<Course> existingCourse = repository.findById(courseID);
        if (existingCourse.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        updatedCourse.setId(courseID); // Ensure ID remains the same
        Course savedCourse = repository.save(updatedCourse);
        return ResponseEntity.ok(savedCourse); // 200 OK
    }
	
}
