package com.cisco.prj.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
	@RequestMapping("greet.do")
	public ModelAndView greetMessage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Welcome to Spring Training!!!"); // model data
		mav.addObject("date", new Date()); // model data
		mav.setViewName("greet.jsp");
		return mav;
	}
}
