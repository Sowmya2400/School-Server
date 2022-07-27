package com.ssm.dto;

import org.springframework.web.multipart.MultipartFile;

public class circularDto {
	
	private int circular_Category;
	private String circular_Date;
	private String circular_Subject;
	private MultipartFile circularFile;
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
	public MultipartFile getCircularFile() {
		return circularFile;
	}
	public void setCircularFile(MultipartFile circularFile) {
		this.circularFile = circularFile;
	}
	
	
	
	
	
}
