package com.ssm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ssm_staff")
public class Staff {
	
	@Id
	@SequenceGenerator(name="staff_seq",initialValue = 100,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "staff_seq")
	private int StaffId;
	private String name;
	private int standard1;
	private char section1;
	private String subject1;
	private int standard2;
	private char section2;
	private String subject2;
	private int standard3;
	private char section3;
	private String subject3;
	private String password;
	
	
	public Staff() {
		super();
	}


	public Staff(String name, int standard1, char section1, String subject1, int standard2, char section2,
			String subject2, int standard3, char section3, String subject3, String password) {
		super();
		this.name = name;
		this.standard1 = standard1;
		this.section1 = section1;
		this.subject1 = subject1;
		this.standard2 = standard2;
		this.section2 = section2;
		this.subject2 = subject2;
		this.standard3 = standard3;
		this.section3 = section3;
		this.subject3 = subject3;
		this.password = password;
	}


	public int getStaffId() {
		return StaffId;
	}


	public void setStaffId(int staffId) {
		StaffId = staffId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getStandard1() {
		return standard1;
	}


	public void setStandard1(int standard1) {
		this.standard1 = standard1;
	}


	public char getSection1() {
		return section1;
	}


	public void setSection1(char section1) {
		this.section1 = section1;
	}



	public int getStandard2() {
		return standard2;
	}


	public void setStandard2(int standard2) {
		this.standard2 = standard2;
	}


	public char getSection2() {
		return section2;
	}


	public void setSection2(char section2) {
		this.section2 = section2;
	}


	public int getStandard3() {
		return standard3;
	}


	public void setStandard3(int standard3) {
		this.standard3 = standard3;
	}


	public char getSection3() {
		return section3;
	}


	public void setSection3(char section3) {
		this.section3 = section3;
	}




	public String getSubject1() {
		return subject1;
	}


	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}


	public String getSubject2() {
		return subject2;
	}


	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}


	public String getSubject3() {
		return subject3;
	}


	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Staff [StaffId=" + StaffId + ", name=" + name + ", standard1=" + standard1 + ", section1=" + section1
				+ ", subject1=" + subject1 + ", standard2=" + standard2 + ", section2=" + section2 + ", subject2="
				+ subject2 + ", standard3=" + standard3 + ", section3=" + section3 + ", subject3=" + subject3
				+ ", password=" + password + "]";
	}
	
	
	
	

}
