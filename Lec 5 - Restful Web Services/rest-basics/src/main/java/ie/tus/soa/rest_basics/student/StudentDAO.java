package ie.tus.soa.rest_basics.student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

// @Component means we want Spring to manage the class. This is @Autowired into the StudentResource class below.
@Component
public class StudentDAO {
	
	private Map<Integer, Student> studentsMap = new HashMap<Integer, Student>();
	
	public StudentDAO() {
		// Create student objects 
		Student s1 = new Student(1, "Joe Bloggs", LocalDate.now().minusYears(20));
		Student s2 = new Student(2, "Anne Bloggs", LocalDate.now().minusYears(30));
		Student s3 = new Student(3, "Billy Bloggs", LocalDate.now().minusYears(20));
		
		studentsMap.put(1, s1);
		studentsMap.put(2, s2);
		studentsMap.put(3, s3);
	}
	
	// Return all students 
	public List<Student> findAll(){
		List<Student> students = new ArrayList<Student>();
		students.addAll(studentsMap.values());
		return students;
	}
	
	// Return specific student
	public Student findByID(int id) {
		return studentsMap.get(id);
	}
	
	// Save new student 
	public Student saveStudent(Student student) {
		// Allocate next ID
		student.setId(getNextID());
		studentsMap.put(student.getId(), student);
		return student;
	}
	
	// Find next ID
	public int getNextID() {
		return studentsMap.size()+1;
	}
	
	// Delete student 
	public boolean deleteStudent(int id) {
		return studentsMap.remove(id) != null;
	}
	
	// Delete all students 
	public boolean deleteStudents() {
		studentsMap.clear();
		return false;
	}
	
	// Update student 
	public Student updateStudent(int id, Student updatedStudent) {
	    if (studentsMap.containsKey(id)) {
	    	// Ensure correct user is updated
	        updatedStudent.setId(id);
	        studentsMap.put(id, updatedStudent);
	        return updatedStudent;
	    }
	    // Null if student not found
	    return null;
	}

}
