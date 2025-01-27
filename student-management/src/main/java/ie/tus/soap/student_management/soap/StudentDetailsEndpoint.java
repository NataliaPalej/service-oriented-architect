// ensure that the below package is the extension of ue.tus.soap.student_management 
package ie.tus.soap.student_management.soap;

import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ie.tus.soap.student_management.soap.bean.Student;
import ie.tus.soap.student_management.soap.data.StudentDao;
import ie.tus.students.DeleteStudentDetailsRequest;
import ie.tus.students.DeleteStudentDetailsResponse;
import ie.tus.students.GetAllStudentDetailsRequest;
import ie.tus.students.GetAllStudentDetailsResponse;
import ie.tus.students.GetStudentDetailsRequest;
import ie.tus.students.GetStudentDetailsResponse;
import ie.tus.students.StudentDetails;

@Endpoint
public class StudentDetailsEndpoint {
	
	// Convert incoming XML to Java
	@PayloadRoot(namespace="http://tus.ie/students", localPart="GetStudentDetailsRequest")
	// Converts Java response to XML
	@ResponsePayload
	public GetStudentDetailsResponse processCourseDetailsRequest(@RequestPayload GetStudentDetailsRequest request) {
		
		GetStudentDetailsResponse response = new GetStudentDetailsResponse();
		
		Student student = StudentDao.instance.getStudent(request.getId());
		StudentDetails studentDetails = new StudentDetails();
		
		studentDetails.setId(student.getId());
		studentDetails.setName(student.getName());
		studentDetails.setAddress(student.getAddress());
		
		response.setStudentDetails(studentDetails);
		
		return response;
	}
	
	@PayloadRoot(namespace="https://tus.ie/students", localPart="GetAllStudentDetailsRequest")
	// This method returns value to be mapped to the response payload
	@ResponsePayload
	public GetAllStudentDetailsResponse processAllStudentDetailsRequest(@RequestPayload GetAllStudentDetailsRequest request) {
		
		GetAllStudentDetailsResponse response = new GetAllStudentDetailsResponse();
	
		// Get student using DAO
		List<Student> students = StudentDao.instance.getAllStudents();
		
		for (Student s : students) {
			StudentDetails studentDetails = new StudentDetails();
			studentDetails.setId(s.getId());
			studentDetails.setName(s.getName());
			studentDetails.setAddress(s.getAddress());
			
			response.getStudentDetails().add(studentDetails);
		}
		return response;
	}
	
	
	@PayloadRoot(namespace = "http://tus.ie/students", localPart = "DeleteStudentDetailsRequest")
	@ResponsePayload
	public DeleteStudentDetailsResponse processDeleteStudentDetails(@RequestPayload DeleteStudentDetailsRequest request) {
	    DeleteStudentDetailsResponse response = new DeleteStudentDetailsResponse();
	    int student = StudentDao.instance.deleteStudent(request.getId());
	    // Set response status
	    response.setStatus(student); 
	    return response;
	}

}

/**
 * NOTES
 * @Endpoint - registers the class with Spring WS as a Web Service Endpoint
 * @PayloadRoot - defines the handles method according to the namespace and localPort attributes
 * @ResponsePayload - indicates that this method returns a value to be mapped to the response payload
 * @RequestPayload - indicates that this method accepts a parameter to be mapped from the incoming request  
 */
