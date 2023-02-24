package com.udit.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.udit.entity.User;

@Component
public class UserDao {

	@Autowired
  private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void addUser(User user) {
		this.hibernateTemplate.saveOrUpdate(user);
	}
	 
	
}
