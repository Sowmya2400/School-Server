package com.ssm.dto;

import java.time.LocalDate;

public class StudentLoginDto {
	private int admnNo;
	private LocalDate dob;
	public int getAdmnNo() {
		return admnNo;
	}
	public void setAdmnNo(int admnNo) {
		this.admnNo = admnNo;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	

}
