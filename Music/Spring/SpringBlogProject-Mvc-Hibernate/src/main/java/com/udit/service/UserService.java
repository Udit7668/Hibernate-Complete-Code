package com.udit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udit.dao.UserDao;
import com.udit.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void addUser(User user) {
		this.userDao.addUser(user);
	}
}
