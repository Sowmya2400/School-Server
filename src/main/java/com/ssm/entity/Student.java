package com.ssm.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="ssm_student")
public class Student {
	
	@Id
	@SequenceGenerator(name="admn_seq",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "admn_seq")
	private int admnNo;
	private String name;
	private LocalDate dob;
	private int standard;
	private char section;
	private String address;
	private BloodGroup bloodGroup;
	private String photo;
	private double balance;
	private String emailId;
	
	@OneToMany(mappedBy="student",cascade = CascadeType.ALL)
	List<Marks> marks;
	
	
	
	public Student() {
		super();
	}
	public Student(String name, LocalDate dob, int standard, char section, String address, BloodGroup bloodGroup,
			String photo, double balance, String emailId) {
		super();
		this.name = name;
		this.dob = dob;
		this.standard = standard;
		this.section = section;
		this.address = address;
		this.bloodGroup = bloodGroup;
		this.photo = photo;
		this.balance = balance;
		this.emailId = emailId;
	}
	public int getAdmnNo() {
		return admnNo;
	}
	public void setAdmnNo(int admnNo) {
		this.admnNo = admnNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public char getSection() {
		return section;
	}
	public void setSection(char section) {
		this.section = section;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public List<Marks> getMarks() {
		return marks;
	}
	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [admnNo=" + admnNo + ", Name=" + name + ", dob=" + dob + ", standard=" + standard + ", section="
				+ section + ", Address=" + address + ", bloodGroup=" + bloodGroup + ", photo=" + photo + ", balance="
				+ balance + ", emailId=" + emailId + "]";
	}
	
	

}
