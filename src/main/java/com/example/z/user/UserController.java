package com.example.z.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping("list")
	public ModelAndView list() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", userService.getList());
		
		return mav;
	}
	
	@RequestMapping("add")
	public void add() throws Exception {
		userService.add();
	}

}
