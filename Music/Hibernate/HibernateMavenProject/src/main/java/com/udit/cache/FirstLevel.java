package com.udit.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udit.HibernateMavenProject.Student;

public class FirstLevel {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.config.xml").buildSessionFactory();
	     Session session=factory.openSession();
	     
	      Student student=  session.get(Student.class,102);
	       System.out.println(student);
	       
	       System.out.println(".........................................................");
	       
	       Student student2=session.get(Student.class, 102);
	       System.out.println(student2);
	     
	     session.close();
	     factory.close();
	
	
	}

}
