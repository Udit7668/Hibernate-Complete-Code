package com.udit.embedded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.config.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	
	Student student=new Student();
	student.setId(121);
	student.setName("Mohan pandey");
	
	Certificate certi=new Certificate();
	certi.setCourse("java");
	certi.setDuration("2 Months");
	student.setCerti(certi);
	
	Session session=factory.openSession();
	Transaction tx=session.beginTransaction();
	session.save(student);
	
	tx.commit();
	
	
	
}

}
