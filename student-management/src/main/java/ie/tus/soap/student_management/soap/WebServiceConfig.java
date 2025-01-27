package ie.tus.soap.student_management.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

// Enable Spring Web Services
@EnableWs
// Spring Configuration
@Configuration
public class WebServiceConfig {
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
	}
	
	/**
	 * NOTES:
	 * The purpose of the above method is to map an instance of the MessageDispatcherServlet
	 * to the url "/ws/*". The MessageDispatcherServlet is responsible for habdling incoming requests
	 * 
	 * @Bean annotation indicates that method produces bean(object) to be managed by the Spring container.
	 * In this case, method will be run and the servlet will be registered for /ws/*.
	 * */
	
	@Bean(name="students")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema studentsSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("StudentPort");
		definition.setTargetNamespace("http://tus.ie/students");
		definition.setLocationUri("/ws");
		definition.setSchema(studentsSchema);
		
		return definition;
	}

	/**
	 * The below creates bean called SstudentsSchema, which is then passed to the 
	 * defaultWsdl11Definition method (managed by Spring)
	 */
	
	@Bean
	public XsdSchema studentsSchema() {
		return new SimpleXsdSchema(new ClassPathResource("student-details.xsd"));
	}
}



