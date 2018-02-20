package com.example.login;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class Login extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 3162142528061080009L;

	private Long id;
	private String name;

	public Login(String username, String password, Collection<? extends GrantedAuthority> authorities, Long id,
			String name) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
