package ie.tus.soap.student_management.soap.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ie.tus.soap.student_management.soap.bean.Student;

public enum StudentDao {
	instance;
	
	private Map<Integer, Student> studentsMap = new HashMap<Integer, Student>();
	
	private StudentDao() {
		Student student1 = new Student(1, "Joe Joe", "Athlone");
		Student student2 = new Student(2, "Mary Mary", "Longford");
		Student student3 = new Student(3, "Billy Billy", "Roscommomn");
		studentsMap.put(1, student1);
		studentsMap.put(2, student2);
		studentsMap.put(3, student3);
	}
	
	public Student getStudent(int id) {
		return studentsMap.get(id);
	}
	
	public List<Student> getAllStudents(){
		List<Student> students = new ArrayList<Student>();
		students.addAll(studentsMap.values());
		return students;
	}
	
	public int deleteStudent(int id) {
		// Return 1 for success, 0 for fail
		if (studentsMap.remove(id) != null) {
			return 1;
		} else {
			return 0;
		}
	}
}
