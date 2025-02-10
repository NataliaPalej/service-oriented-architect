package ie.tus.soa.spring_boot_intro;

public class Course {
	
	private String name, lecturer;
	private long id;
	
	public Course() {
		
	}
	
	public Course(int id, String subject, String lecturer) {
		super();
		this.id = id;
		this.name = subject;
		this.lecturer = lecturer;
	}

	public String getSubject() {
		return name;
	}

	public void setSubject(String subject) {
		this.name = subject;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Course\nID: " + id + "\tName: " + name + "\nLecturer" + lecturer + "\n";
	}
}
