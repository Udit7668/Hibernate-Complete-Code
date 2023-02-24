package com.udit.embedded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

	public static void main(String[] args) {
	  Configuration cfg=new Configuration();
	  cfg.configure("hibernate.config.xml");
      SessionFactory factory= cfg.buildSessionFactory();
      
      //creating student object
      Student student=new Student();
      student.setId(1222);
       student.setName("Ramesh Maurya");
       student.setCerti(new Certificate("Java Hibernate Course","2 Months"));
       // Now object is in Transient state
       
       Session session=factory.openSession();
       Transaction tx=session.beginTransaction();
       session.save(student);
       //NOw object is avialable for both session and database-Persistent state
       
       
       tx.commit();
       session.close();
       //student came in detached state
       
       student.setName("MOhan pandey");//it will not reflected in database now
      factory.close();
	}

}
