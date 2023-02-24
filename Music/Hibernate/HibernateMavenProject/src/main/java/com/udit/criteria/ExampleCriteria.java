package com.udit.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.udit.HibernateMavenProject.Student;

public class ExampleCriteria {
public static void main(String[] args) {
SessionFactory factory=new 	Configuration().configure("hibernate.config.xml").buildSessionFactory();	
  Session session=factory.openSession();
 
 Criteria criteria= session.createCriteria(Student.class);
   
 
//criteria.add(Restrictions.eq("id", 102));--this will use to put restriction on our sql query
 List<Student> list=criteria.list();
 		
 for(Student st:list) {
	 System.out.println(st.getStudentName()+" : "+st.getStudentCity());
 }
 
session.close();
factory.close();
}
}
