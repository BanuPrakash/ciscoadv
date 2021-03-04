package com.cisco.prj.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.cisco.prj.service.EmailService;

@Configuration
public class MyConfig {
	
	@Bean
	public EmailService emailService() {
		EmailService em = new EmailService("pop3.gmail.com", 1234);
		// set other info
		return em;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
}
