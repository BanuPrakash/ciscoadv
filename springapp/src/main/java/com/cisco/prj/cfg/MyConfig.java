package com.cisco.prj.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cisco.prj.service.EmailService;

@Configuration
public class MyConfig {
	
	@Bean
	public EmailService emailService() {
		EmailService em = new EmailService("pop3.gmail.com", 1234);
		// set other info
		return em;
	}
}
