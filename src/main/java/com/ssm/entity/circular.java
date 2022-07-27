package com.ssm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ssm_circular")
public class circular {
	
	@Id
	@SequenceGenerator(name="circular_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "circular_seq")
	private int circular_id;
	
	private int circular_Category;
	private String circular_Date;
	private String circular_Subject;
	private String circularFile;
	
	
	public circular() {
		super();
	}


	public circular(int circular_Category, String circular_Date, String circular_Subject, String circularFile) {
		super();
		this.circular_Category = circular_Category;
		this.circular_Date = circular_Date;
		this.circular_Subject = circular_Subject;
		this.circularFile = circularFile;
	}


	public int getCircular_id() {
		return circular_id;
	}


	public void setCircular_id(int circular_id) {
		this.circular_id = circular_id;
	}


	public int getCircular_Category() {
		return circular_Category;
	}


	public void setCircular_Category(int circular_Category) {
		this.circular_Category = circular_Category;
	}


	public String getCircular_Date() {
		return circular_Date;
	}


	public void setCircular_Date(String circular_Date) {
		this.circular_Date = circular_Date;
	}


	public String getCircular_Subject() {
		return circular_Subject;
	}


	public void setCircular_Subject(String circular_Subject) {
		this.circular_Subject = circular_Subject;
	}


	public String getCircularFile() {
		return circularFile;
	}


	public void setCircularFile(String circularFile) {
		this.circularFile = circularFile;
	}
	

	

}
