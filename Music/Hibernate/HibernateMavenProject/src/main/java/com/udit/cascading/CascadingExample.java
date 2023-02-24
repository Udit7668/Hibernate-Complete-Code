package com.udit.cascading;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.onetomany.Answer;
import com.map.onetomany.Question;

public class CascadingExample {

	public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.config.xml");
	SessionFactory factory=cfg.buildSessionFactory();
    Session session=factory.openSession();
    Transaction tx=session.beginTransaction();
//    
//    Question q1=new Question();
//    q1.setQuestionId(568);
//    q1.setQuestion("What is cascading?");
//    
//    Answer ans1=new Answer();
//    ans1.setAnswerId(43);
//    ans1.setAnswer("it is property of hibernate");
//    
//    Answer ans2=new Answer();
//    ans2.setAnswer("Second answer");
//    ans2.setAnswerId(44);
//    
//    Answer ans3=new Answer();
//    ans3.setAnswerId(45);
//    ans3.setAnswer("Third answer");
//    
//    List<Answer> list=new ArrayList<Answer>();
//    list.add(ans1);
//    list.add(ans2);
//    list.add(ans3);
//     
//    q1.setAnswers(list);
//    
//    session.save(q1);
//    session.save(ans1);
//    session.save(ans2);
//    session.save(ans3);
    
    
    
    Question q1=new Question();
    q1.setQuestionId(569);
    q1.setQuestion("What is Windows?");
    
    Answer ans1=new Answer();
    ans1.setAnswerId(43);
    ans1.setAnswer("it is property of windows");
    
    Answer ans2=new Answer();
    ans2.setAnswer("Second answer of Windows");
    ans2.setAnswerId(44);
    
    Answer ans3=new Answer();
    ans3.setAnswerId(45);
    ans3.setAnswer("Third answer of Windows");
    
    List<Answer> list=new ArrayList<Answer>();
    list.add(ans1);
    list.add(ans2);
    list.add(ans3);
     
    q1.setAnswers(list);
    
    session.save(q1);//after using cascade we donot need any need to save all answer objects
   
    tx.commit();
    session.close();
    factory.close();
    
    
	}

}
