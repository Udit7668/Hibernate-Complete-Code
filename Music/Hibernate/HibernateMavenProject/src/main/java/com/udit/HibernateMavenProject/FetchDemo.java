package com.udit.HibernateMavenProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
 public static void main(String[] args) {
		Configuration cfg=new Configuration();
	      cfg.configure("hibernate.config.xml");
	       SessionFactory factory=cfg.buildSessionFactory();
	    Session session=factory.openSession();
	      
	    
	          Student student=(Student)session.get(Student.class,101);
	    		System.out.println(student);
       Student st=    session.load(Student.class, 102);
	      System.out.println(st);
	      
	      
	        Address ad=new Address();
	        ad= session.get(Address.class,1);
	        System.out.println(ad);
	      session.close();
	      factory.close();
 }
}
