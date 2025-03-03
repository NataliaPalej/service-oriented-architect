package ie.tus.eng.rest_basics_jpa.student;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.tus.eng.rest_basics_jpa.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
