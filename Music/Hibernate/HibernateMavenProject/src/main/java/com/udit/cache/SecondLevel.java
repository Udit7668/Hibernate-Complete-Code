package com.udit.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udit.HibernateMavenProject.Student;



public class SecondLevel {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.config.xml").buildSessionFactory();
         
		Session session=factory.openSession();
		 Student student=session.get(Student.class, 102);
		System.out.println(student);
		
		session.close();
		
		
		Session session1=factory.openSession();
		
		 Student student1=session1.get(Student.class, 102);
			System.out.println(student1);
			
		
		session1.close();
		factory.close();
	}

}
