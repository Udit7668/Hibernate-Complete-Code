package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hibernate.config.xml").buildSessionFactory();
	   Session session= factory.openSession();
	   Transaction tx=session.beginTransaction();
	   Person person=new Person(121,"Udit Mishra","Gorakhpur","7355206348");
	   session.save(person);
	   
	   
	   tx.commit();
	
	   session.close();
	   factory.close();
	   
	}

}
