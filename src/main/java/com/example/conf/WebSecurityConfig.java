package com.example.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// public
		http.authorizeRequests().antMatchers("/", "/index.abc").permitAll();

		// admin
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");

		// user
		http.authorizeRequests().antMatchers("/**").hasRole("USER");

		http.formLogin().defaultSuccessUrl("/").and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
	}

}
