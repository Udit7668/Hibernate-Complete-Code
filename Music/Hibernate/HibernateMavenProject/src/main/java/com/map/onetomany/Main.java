package com.map.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.config.xml");
		SessionFactory factory = cfg.buildSessionFactory();

//		Question q = new Question();
//		q.setQuestionId(1212);
//		q.setQuestion("What is java?");
//
//		Answer ans = new Answer();
//		ans.setAnswerId(343);
//		ans.setAnswer("Java is a Programming language");
//		ans.setQuestion(q);
//
//		Answer ans1 = new Answer();
//		ans1.setAnswerId(33);
//		ans1.setAnswer("By using this we can createCollection framework");
//		ans1.setQuestion(q);
//		Answer ans2 = new Answer();
//		ans2.setAnswerId(363);
//		ans2.setAnswer("Java is OBject oriented programming language");
//		ans2.setQuestion(q);
//		List<Answer> list = new ArrayList<Answer>();
//		list.add(ans);
//		list.add(ans1);
//		list.add(ans2);
//
//		
//		 q.setAnswers(list);
		 
		 Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
//         session.save(q);
//         session.save(ans);
//         session.save(ans1);
//		session.save(ans2);
//       
       
          Question question=session.load(Question.class,1212);
             System.out.println(question.getQuestion());
             System.out.println(question.getQuestionId());
           System.out.println(question.getAnswers().size());
		tx.commit();
		session.close();
		factory.close();
	}

}
