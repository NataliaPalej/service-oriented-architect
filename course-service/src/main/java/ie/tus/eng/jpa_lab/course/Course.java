package ie.tus.eng.jpa_lab.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="course")	// Specifies table name
public class Course {
	@Id
	private long courseID;
	@Column(name="name")
	private String name;
	@Column(name="code")
	private String code;
	
	public Course() {
		super();
	}
	
	public Course(long courseID, String name, String code) {
		super();
		this.courseID=courseID;
		this.name=name;
		this.code=code;
	}

	public long getId() {
		return courseID;
	}

	public void setId(long courseID) {
		this.courseID = courseID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", name=" + name + ", code=" + code + "]";
	}

}