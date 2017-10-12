package com.example.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.resovlers.JsonViewResolver;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("redirect:/index.abc");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);

		super.addViewControllers(registry);
	}

	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(true);

		Map<String, MediaType> mediaTypes = new HashMap<String, MediaType>();
		mediaTypes.put("abc", MediaType.TEXT_HTML);

		configurer.mediaTypes(mediaTypes);

		configurer.defaultContentType(MediaType.APPLICATION_JSON);
	}

	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager contentNegotiationManager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(contentNegotiationManager);

		List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();

		viewResolvers.add(jsonViewResolver());
		viewResolvers.add(jspViewResolver());

		resolver.setViewResolvers(viewResolvers);

		return resolver;
	}

	@Bean
	public ViewResolver jsonViewResolver() {
		return new JsonViewResolver();
	}

	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

}
