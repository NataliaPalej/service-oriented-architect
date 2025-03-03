package ie.tus.eng.rest_basics_jpa.course;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="course-service", url="http://localhost:8081")
public interface CourseClient {
	@GetMapping("/courses/{courseID}")
	Course getCourseById(@PathVariable long courseID);
}
