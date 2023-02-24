package com.map.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.config.xml");
         SessionFactory factory=cfg.buildSessionFactory();
        
         Employee emp1=new Employee();
         Employee emp2=new Employee();
           
         emp1.setEid(34);
         emp1.setName("Ram");
         
         emp2.setEid(35);
         emp2.setName("Shyam");
        
         Project p1=new Project();
         Project p2=new Project();
         
         p1.setEid(12121);
         p1.setProjectName("Library Management System");
         
         p2.setEid(14214);
         p2.setProjectName("chatBot");
         
         List<Employee> list1=new ArrayList<Employee>();
         List<Project> list2=new ArrayList<Project>();
         
         list1.add(emp1);
         list1.add(emp2);
         
         list2.add(p1);
         list2.add(p2);
         
         emp1.setProjects(list2);
         p2.setEmployee(list1);
         
         Session session=factory.openSession();
         Transaction tx=session.beginTransaction();
         
         
         session.save(emp1);
         session.save(emp2);
         session.save(p1);
         session.save(p2);
         
         
         tx.commit();
         session.close();
         
         factory.close();
	}

}
