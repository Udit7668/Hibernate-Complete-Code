package com.udit.hql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.udit.HibernateMavenProject.Student;

public class DemoHql {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.config.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        
//        String query="from Student";
//       Query q= session.createQuery(query); 
//        
//       List<Student> list=q.list();
//       
//  
    
         Transaction tx=session.beginTransaction();
        //delete 	Query
        System.out.println("--------------------------------------------------------------");
//       Query q= session.createQuery("delete from Student where studentId=:c");
//          q.setParameter("c",101);
//         int r= q.executeUpdate();
//          System.out.println(r+" Rows Deleted");
//       
        
//      Update query  
//          Query q2= session.createQuery("update Student set studentName=:x where studentId=:c");
//            q2.setParameter("x", "Ramesh Maurya");
//             q2.setParameter("c", 102);
//            int r= q2.executeUpdate();
//            System.out.println(r+" Rows Affacted");
       
        
        
        
        //executing join query
        
        Query q3=session.createQuery("select q.questionId,q.question,a.answer from Question as q INNER JOIN q.answers as a");
        List<Object[]> list3=q3.list();
        for(Object[] arr:list3) {
        	System.out.println(Arrays.toString(arr));
        }
        
        tx.commit();
        factory.close();
	}

}
