package ie.tus.eng.jpa_lab.course.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.tus.eng.jpa_lab.course.Course;

public interface CourseJpaRepository extends JpaRepository<Course, Long>{
	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
}
