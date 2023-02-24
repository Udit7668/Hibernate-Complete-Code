package com.map.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "question1")
public class Question {
	
@Id
@Column(name="question_id")
private int questionId;
private String question;

@OneToMany(mappedBy ="question",fetch = FetchType.LAZY,cascade = CascadeType.ALL)//this will help you not create the tables with question1_answer1
private List<Answer> answers;
public Question(int questionId, String question, List<Answer> answers) {
	super();
	this.questionId = questionId;
	this.question = question;
	this.answers = answers;
}
@Override
public String toString() {
	return "Question [questionId=" + questionId + ", question=" + question + ", answers=" + answers + "]";
}
public List<Answer> getAnswers() {
	return answers;
}
public void setAnswers(List<Answer> answers) {
	this.answers = answers;
}
public int getQuestionId() {
	return questionId;
}
public void setQuestionId(int questionId) {
	this.questionId = questionId;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public Question() {
	super();
	// TODO Auto-generated constructor stub
}

}
