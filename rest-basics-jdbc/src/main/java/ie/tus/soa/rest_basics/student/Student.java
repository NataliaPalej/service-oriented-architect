package ie.tus.soa.rest_basics.student;

import java.time.LocalDate;

public class Student {
	
	private int id;
	private String name;
	private LocalDate birthDate;
	
	public Student(int id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public Student() {
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
	
	public String toString() {
		return "Student\nID: " + id + "\tName: " + name + "\tBirthDate: " + birthDate;
	}

}
