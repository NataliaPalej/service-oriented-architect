package ie.tus.soa.rest_basics.student.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.tus.soa.rest_basics.student.Student;

// @Component means we want Spring to manage the class. This is @Autowired into the StudentResource class below.
@Repository
public class StudentJdbcResource {
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY="INSERT INTO student VALUES(?, ?, ?)";
	private static String DELETE_QUERY="DELETE FROM student WHERE ID=?";
	private static String SELECT_QUERY="SELECT * FROM student WHERE ID=?";
	private static String SELECT_ALL="SELECT * FROM student";
	
	public void insert(Student s) {
		springJdbcTemplate.update(INSERT_QUERY, s.getId(), s.getName(), s.getBirthDate());
	}
	
	public void delete(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
	
	public Student findById(int id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Student.class), id);
	}
	
	public List<Student> findAll(){
		return springJdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<>(Student.class));
	}
	
} 
