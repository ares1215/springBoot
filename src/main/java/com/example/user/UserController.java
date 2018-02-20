package com.example.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@RequestMapping("list")
	public String list(Model model, Pageable pageable) throws Exception {
		Page<User> results = userService.getListByPage(pageable);
		model.addAttribute("user", results);

		return "user/list";
	}

	@RequestMapping("add")
	public void add(User user) throws Exception {
		userService.add(user);
	}

	@RequestMapping("edit")
	public void edit(User user) throws Exception {
		userService.edit(user);
	}

	@RequestMapping("remove")
	public void remove(Long id) throws Exception {
		userService.remove(id);
	}
}
