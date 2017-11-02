package com.example.z.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public List<User> getList() throws Exception {
		return userDao.findAll();
	}

	public void add() {
		User user = new User();
		user.setLoginId("test");
		user.setName("test");
		user.setPassword("1234");
		
		userDao.save(user);
	}

}
