package com.cisco;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	@RequestMapping("/hello")
	public String greeting() {
		return "Hello Spring Security !!!";
	}
}
