package com.example.z.admin;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Secured("ADMIN")
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping("/")
	public Model admin(Model model) {
		model.addAttribute("admin", SecurityContextHolder.getContext().getAuthentication().getPrincipal());

		return model;
	}

}
