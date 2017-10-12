package com.example.z.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/index")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("msg", "index!!");
		
		return mav;
	}

}