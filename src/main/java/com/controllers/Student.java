package com.controllers;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends Passport {

	@Id
	@Column(name = "sid")
	@GeneratedValue
	private int studId;

	@Column(name = "sname")
	private String name;

	@Column(name = "clg")
	private String college;

/*	private List<Address> cities;

	private Passport ppt;

	public Passport getPpt() {
		return ppt;
	}

	public void setPpt(Passport ppt) {
		this.ppt = ppt;
	}*/

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;

	}
	/*public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}*/
	
	public void init() {
		System.out.println("init executed");
	}
	
	public void destroy() {
		System.out.println("destroy executed");
	}
	
}
