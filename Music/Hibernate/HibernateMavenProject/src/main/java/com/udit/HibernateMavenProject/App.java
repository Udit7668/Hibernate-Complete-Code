package com.udit.HibernateMavenProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
       //Way-1 to get session factory object
    	//SessionFactory factory=new Configuration().configure().buildSessionFactory();
     
    	
    	
    	// Way-2 to get session factory object
    	Configuration cfg=new Configuration();
      cfg.configure("hibernate.config.xml");
      SessionFactory factory=cfg.buildSessionFactory();
		/*
		 * System.out.println(factory); System.out.println(factory.isClosed());
		 */
       
		/*
		 * Student student=new Student(); student.setStudentId(102);
		 * student.setStudentName("Umesh"); student.setStudentCity("Haridwar");
		 * 
		 * 
		 * System.out.println(student);
		 */
      
      Address ad=new Address();
      
      ad.setAddressId(123);
      ad.setStreet("Gandhi NAGAR");
      ad.setCity("Sant Kabir nagar");
      ad.setOPen(true);
      ad.setAddedDate(new Date());
      ad.setX(123.56);
      
      
      //reading image
      
      FileInputStream fs=new FileInputStream("src/main/java/extra_runs.png");
      byte[] data=new byte[fs.available()];
      fs.read(data);
      ad.setImage(data);
     Session session=  factory.openSession();
     Transaction tx=session.beginTransaction();
		/* session.save(student); */
     
        session.save(ad);
     tx.commit();
     session.close();
       
    }
}
