package com.example.resovlers;

import java.util.Locale;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class JsonViewResolver implements ViewResolver {

	@Override
	public org.springframework.web.servlet.View resolveViewName(String viewName, Locale locale) throws Exception {
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		jsonView.setPrettyPrint(true);

		return jsonView;
	}

}
