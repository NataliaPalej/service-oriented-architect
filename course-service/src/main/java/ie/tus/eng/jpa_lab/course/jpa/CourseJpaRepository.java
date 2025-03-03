package ie.tus.eng.jpa_lab.course.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.tus.eng.jpa_lab.course.Course;

// http://localhost:8080/courses
public interface CourseJpaRepository extends JpaRepository<Course, Long>{
	List<Course> findByCode(String code);
	List<Course> findByName(String name);
}
