package com.example.z.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> getListAll() {
		return (List<User>) userRepository.findAll();
	}

	public Page<User> getListByPage(Pageable pageable) throws Exception {
		return (Page<User>) userRepository.findAll(pageable);
	}

	public void add() {
		User user = new User();
		user.setLoginId("test");
		user.setName("test");
		user.setPassword("1234");

		userRepository.save(user);
	}
	
	public void update() {
		User user = userRepository.findOne(7);
		user.setName("아아아아");
		userRepository.save(user);
	}

}
