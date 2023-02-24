package com.map.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;

public class Main {
public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.config.xml");
	SessionFactory factory= cfg.buildSessionFactory();
	
	
	Question q=new Question();
	q.setQuestionId(1212);
	q.setQuestion("What is java?");
	
	Answer ans=new Answer();
	ans.setAnswerId(343);
	ans.setAnswer("Java is a Programming language");
	ans.setQuestion(q);
	q.setAnswer(ans);
	
	Question q1=new Question();
	q1.setQuestionId(242);
	q1.setQuestion("What is Collection Framework?");
	
	Answer ans1=new Answer();
	ans1.setAnswerId(344);
	ans1.setAnswer("API to work with java Objects");
	ans1.setQuestion(q1);
	q1.setAnswer(ans1);
	
	Session session=factory.openSession();
	Transaction tx=session.beginTransaction();
	
	session.save(q);
	session.save(q1);
	
	session.save(ans);
	session.save(ans1);
	
	tx.commit();
	
	Question q2=session.get(Question.class,1212);
	System.out.println(q2.getQuestion());
	System.out.println(q2.getAnswer().getAnswer());
	factory.close();
}
}
