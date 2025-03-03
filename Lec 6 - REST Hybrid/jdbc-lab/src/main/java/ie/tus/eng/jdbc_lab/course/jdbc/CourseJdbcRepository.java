package ie.tus.eng.jdbc_lab.course.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.tus.eng.jdbc_lab.course.Course;

// @Repository specialization of @Component, it is used for classes to talk to db
@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
//	private static String INSERT_QUERY = "INSERT INTO COURSE VALUES (1, 'Learn Spring', 'Enda')";
//	
//	public void insert() {
//		// Update method can be used for insert, update and delete
//		springJdbcTemplate.update(INSERT_QUERY);
//	}
	
	private static String INSERT_QUERY="INSERT INTO COURSE VALUES(?, ?, ?)";
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	private static String DELETE_QUERY="DELETE FROM COURSE WHERE ID=?";
	
	public void delete(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
	
	/*
	 * Using queryForObject method we know theres just one object coming 
	 * BeanPropertyMapper converts from the ResultSet to Course object
	 */
	private static String SELECT_QUERY="SELECT * FROM COURSE WHERE ID=?";
	
	public Course findById(int id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
	
	/*
	 * To retrieve all course objects
	 */
	private static String SELECT_ALL="SELECT * FROM COURSE";
	
	public List<Course> findAll(){
		return springJdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<>(Course.class));
	}
}
