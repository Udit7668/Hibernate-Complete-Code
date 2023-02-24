package com.udit.embedded;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_embedded")
public class Student {
	@Id
  private int id;
  private String name;
  private Certificate certi;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Certificate getCerti() {
	return certi;
}
public void setCerti(Certificate certi) {
	this.certi = certi;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(int id, String name, Certificate certi) {
	super();
	this.id = id;
	this.name = name;
	this.certi = certi;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", certi=" + certi + "]";
}
	
}
