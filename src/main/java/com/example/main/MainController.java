package com.example.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("index")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Main!!");

		return mav;
	}

}
