package com.example.sys.conf;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.servlet.view.JstlView;

import com.example.sys.resovlers.JsonViewResolver;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("redirect:/index");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);

		super.addViewControllers(registry);
	}

	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(true).defaultContentType(MediaType.TEXT_HTML);
	}

	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager contentNegotiationManager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(contentNegotiationManager);

		List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();

		viewResolvers.add(jspViewResolver());
		viewResolvers.add(jsonViewResolver());

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
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

}
