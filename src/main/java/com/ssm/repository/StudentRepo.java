package com.ssm.repository;

import java.time.LocalDate;
import java.util.List;

import com.ssm.entity.Exams;
import com.ssm.entity.Marks;
import com.ssm.entity.Student;
import com.ssm.entity.circular;

public interface StudentRepo {
	public boolean verifyCustomer(int admnNo,LocalDate dob);
	public Marks viewMarks(int admnNo,Exams exam);
	public Student stuDetails(int admnNo);
	public Long noOfStuInStd(int standard);
	public double calculateTotal(int admnNo,Exams exam);
	public double calculateTotalMarks(Marks mark);
	public int calculateRank(int admnNo,Exams exam);
	public double viewBalance(int admnNo);
	public double changeBalance(int admnNo,double newBalance);
	public List<String> viewGalleryPics(int category);
	public List<circular> viewCirculars();

}
