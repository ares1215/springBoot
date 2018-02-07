package com.example.z.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("listAll")
	public ModelAndView listAll() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", userService.getListAll());

		return mav;
	}

	@RequestMapping("list")
	public ModelAndView list(Pageable pageable) throws Exception {
		ModelAndView mav = new ModelAndView();
		Page<User> results = userService.getListByPage(pageable);

		mav.addObject("users", results);

		return mav;
	}

	@RequestMapping("add")
	public void add() throws Exception {
		userService.add();
	}
	
	@RequestMapping("update")
	public void update() throws Exception {
		userService.update();
	}

}
