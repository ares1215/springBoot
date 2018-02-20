package com.example.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.login.LoginService;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepository userRepository;

	public Page<User> getListByPage(Pageable pageable) throws Exception {
		logger.info("current login {}", LoginService.getLogin());
		return (Page<User>) userRepository.findAll(pageable);
	}

	public void add(User user) throws Exception {
		userRepository.save(user);
	}

	public void edit(User user) throws Exception {
		userRepository.save(user);
	}

	public void remove(Long id) throws Exception {
		userRepository.delete(id);
	}

	public User findOneByLoginId(String loginId) throws Exception {
		return userRepository.findOneByLoginId(loginId);
	}
}
