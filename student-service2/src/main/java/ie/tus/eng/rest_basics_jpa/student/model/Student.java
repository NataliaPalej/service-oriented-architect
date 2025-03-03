package ie.tus.eng.rest_basics_jpa.student.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
    @GeneratedValue
	private int id;
	private String name;
	private LocalDate birthDate;
	private int courseID;
	
	public Student() {
		super();
	}
	
	public Student(int id, String name, LocalDate birthDate, int courseID) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.courseID = courseID;
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

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", courseID=" + courseID + "]";
	}
}
