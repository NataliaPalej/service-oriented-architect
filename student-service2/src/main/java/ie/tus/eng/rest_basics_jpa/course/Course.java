package ie.tus.eng.rest_basics_jpa.course;

public class Course {
	private long courseID;
	private String name;
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