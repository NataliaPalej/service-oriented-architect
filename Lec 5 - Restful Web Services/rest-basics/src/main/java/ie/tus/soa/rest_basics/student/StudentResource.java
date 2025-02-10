package ie.tus.soa.rest_basics.student;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class StudentResource {
	private StudentDAO dao;
	
	@Autowired
	public StudentResource(StudentDAO dao) {
		this.dao = dao;
	}
	
	@GetMapping("/students")
	public List<Student> findAllStudents(){
		return dao.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Student findStudent(@PathVariable int id) {
		Student student = dao.findByID(id);
		return student;
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		Student savedStudent = dao.saveStudent(student);
		
		// Get URI of created student
		URI location = ServletUriComponentsBuilder
				// gets "/student" part of URI
				.fromCurrentRequest()
				// adds "id" part to it
				.path("/{id}")
				// build and fill the actual id 
				.buildAndExpand(savedStudent.getId())
				// convert to URI object 
				.toUri();
		
		// return response 201 (created) and its location
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
	    boolean deleted = dao.deleteStudent(id);

	    if (deleted) {
	    	// 204 No Content
	        return ResponseEntity.noContent().build();  
	    } else {
	    	// 404 Not Found
	        return ResponseEntity.notFound().build(); 
	    }
	}

	
	@DeleteMapping("/students")
	public ResponseEntity<Void> deleteAllStudents() {
		
		boolean deleted = dao.deleteStudents();
		
		if (deleted) {
	    	// 204 No Content
	        return ResponseEntity.noContent().build();  
	    } else {
	    	// 404 Not Found
	        return ResponseEntity.notFound().build(); 
	    }
	}
	
	// Update student
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
	    Student updatedStudent = dao.updateStudent(id, student);

	    if (updatedStudent != null) {
	        return ResponseEntity.ok(updatedStudent); // Return updated student with 200 OK
	    } else {
	        return ResponseEntity.notFound().build(); // Return 404 if student not found
	    }
	}
}
