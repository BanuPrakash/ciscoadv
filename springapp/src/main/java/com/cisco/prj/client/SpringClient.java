package com.cisco.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cisco.prj.entity.Employee;
import com.cisco.prj.service.SampleService;

public class SpringClient {

	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.cisco");
		ctx.refresh();
		
		SampleService service = ctx.getBean("sampleService", SampleService.class);
		
		Employee e = new Employee();
		service.insertEmployee(e);
		
		System.out.println("**********");
		
		String[] names = ctx.getBeanDefinitionNames();
		
		for(String name: names) {
			System.out.println(name);
		}
	}

}
