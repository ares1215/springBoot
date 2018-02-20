package com.example.login;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.user.User;
import com.example.user.UserService;

@Service
public class LoginService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		try {
			user = userService.findOneByLoginId(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 사용자 권한 처리시....
		// Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		// for (Role role : user.getRoles()) {
		// grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		// }

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		return new Login(user.getLoginId(), user.getPassword(), grantedAuthorities, user.getId(), user.getName());
	}

	public static Login getLogin() throws Exception {
		Login login = (Login) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return login;
	}
}
