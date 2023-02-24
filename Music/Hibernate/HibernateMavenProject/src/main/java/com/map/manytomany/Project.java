package com.map.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {
  @Id
	private int eid;
  @Column(name="project_name")
	private String projectName;
	
  @ManyToMany(mappedBy = "projects")
  
    private List<Employee> employee;

public int getEid() {
	return eid;
}

public void setEid(int eid) {
	this.eid = eid;
}

public String getProjectName() {
	return projectName;
}

public void setProjectName(String projectName) {
	this.projectName = projectName;
}

public List<Employee> getEmployee() {
	return employee;
}

public void setEmployee(List<Employee> employee) {
	this.employee = employee;
}

public Project(int eid, String projectName, List<Employee> employee) {
	super();
	this.eid = eid;
	this.projectName = projectName;
	this.employee = employee;
}

public Project() {
	super();
	// TODO Auto-generated constructor stub
}
  
  
}
