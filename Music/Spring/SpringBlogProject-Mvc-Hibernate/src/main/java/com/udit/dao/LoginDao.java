package com.udit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.udit.entity.User;

@Component
public class LoginDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public boolean checkUser(String email,String password) {
	SessionFactory factory=	this.hibernateTemplate.getSessionFactory();
	 Session session= factory.openSession();
	  Query query=session.createQuery("from User where email like :c and password like :d");
	  query.setParameter("c", email);
	  query.setParameter("d", password);
	  List<User> list=query.getResultList();
	  if(!list.isEmpty()) {
		  return true;
	  }else {
		return false;
	  }
	}
}
