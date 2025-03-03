package ie.tus.eng.rest_basics_jpa.student.model;

import java.time.LocalDate;

import ie.tus.eng.rest_basics_jpa.course.Course;

public class StudentResponse {
	
	private int id; 
	private String name;
	private LocalDate birthDate;
	private Course course;
	
	public StudentResponse(Student student, Course course) {
		this.id = student.getId();
		this.name = student.getName();
		this.birthDate = student.getBirthDate();
		this.course = course;
	}
	
	public StudentResponse() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "StudentResponse [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", course=" + course + "]";
	}
	
	

}
