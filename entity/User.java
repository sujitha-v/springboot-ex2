package com.example.springbootcrudrestwebservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Users")

public class User {

private Long id;

@NotNull
@Size(min=2, message="min 2 characters for name")
private String fname;

@NotNull
@Size(min=2, message="min 2 characters for name")
@Pattern(regexp="^[a-zA-Z]*$", message="name includes only characters")
private String lname;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

@Column(name="first_name",nullable=false)
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}

@Column(name="last_name", nullable=false)
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public User(Long id, String fname, String lname) {
	super();
	this.id = id;
	this.fname = fname;
	this.lname = lname;
}
public User() {
	
}

}
