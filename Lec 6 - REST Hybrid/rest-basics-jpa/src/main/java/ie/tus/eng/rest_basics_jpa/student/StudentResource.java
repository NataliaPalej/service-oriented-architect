package ie.tus.eng.rest_basics_jpa.student;

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

@RestController
public class StudentResource {
	private StudentRepository repository;
	
	@Autowired
	public StudentResource(StudentRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/students")
	public List<Student> retrieveAllStudents(){
		return repository.findAll();
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> retrieveStudent(@PathVariable int id){
		Optional<Student> student = repository.findById(id);
		
		if(student.isEmpty()) {
			System.out.println("Student not found.");
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(student.get());
		}
	}
	
	@DeleteMapping
    public ResponseEntity<Void> deleteAllStudents() {
		repository.deleteAll();
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = repository.save(student);
        URI location = URI.create("/students/" + savedStudent.getId());
        return ResponseEntity.created(location).body(savedStudent); // 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        Optional<Student> existingStudent = repository.findById(id);
        if (existingStudent.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        updatedStudent.setId(id); // Ensure ID remains the same
        Student savedStudent = repository.save(updatedStudent);
        return ResponseEntity.ok(savedStudent); // 200 OK
    }
	
}
