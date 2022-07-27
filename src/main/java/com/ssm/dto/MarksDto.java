package com.ssm.dto;

import com.ssm.entity.Exams;

public class MarksDto {
	private String exam;
	private double sub1;
	private double sub2;
	private double sub3;
	private double sub4;
	private double sub5;
	private int admnNo;
	
	private String sub;
	private double mark;
	
	
	
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getExam() {
		return exam;
	}
	public void setExam(String exam) {
		this.exam = exam;
	}
	public double getSub1() {
		return sub1;
	}
	public void setSub1(double sub1) {
		this.sub1 = sub1;
	}
	public double getSub2() {
		return sub2;
	}
	public void setSub2(double sub2) {
		this.sub2 = sub2;
	}
	public double getSub3() {
		return sub3;
	}
	public void setSub3(double sub3) {
		this.sub3 = sub3;
	}
	public double getSub4() {
		return sub4;
	}
	public void setSub4(double sub4) {
		this.sub4 = sub4;
	}
	public double getSub5() {
		return sub5;
	}
	public void setSub5(double sub5) {
		this.sub5 = sub5;
	}
	public int getAdmnNo() {
		return admnNo;
	}
	public void setAdmnNo(int admnNo) {
		this.admnNo = admnNo;
	}
	
	
}
