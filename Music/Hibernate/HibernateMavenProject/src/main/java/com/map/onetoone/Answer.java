package com.map.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {
	
@Id
@Column(name="anwer_id")
private int answerId;
private String answer;

@OneToOne(mappedBy = "answer")//it will hide the extra columns
private Question question;

public Question getQuestion() {
	return question;
}
public void setQuestion(Question question) {
	this.question = question;
}
public int getAnswerId() {
	return answerId;
}
public void setAnswerId(int answerId) {
	this.answerId = answerId;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
public Answer(int answerId, String answer) {
	super();
	this.answerId = answerId;
	this.answer = answer;
}
public Answer() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Answer [answerId=" + answerId + ", answer=" + answer + "]";
}

}
