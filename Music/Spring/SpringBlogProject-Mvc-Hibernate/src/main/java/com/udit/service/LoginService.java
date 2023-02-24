package com.udit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udit.dao.LoginDao;
@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;
	
	public boolean checkUser(String email,String password){
	boolean result=	this.loginDao.checkUser(email, password);
	return result;
	}
	
}
