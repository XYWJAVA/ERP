package com.bdqn.entity;

import java.util.Date;

/**
 * 多
 * @author weishi
 *
 */
public class Student {
	
	private Integer sno;
	
	private String sname;
	
	private String spass;
	
	private Date birthdate;
	
	private Grade grade;//将一的对象作属性
	
	

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSpass() {
		return spass;
	}

	public void setSpass(String spass) {
		this.spass = spass;
	}
	
	

}
