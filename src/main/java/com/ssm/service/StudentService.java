package com.ssm.service;

import java.time.LocalDate;
import java.util.List;

import com.ssm.entity.BloodGroup;
import com.ssm.entity.Exams;
import com.ssm.entity.Marks;
import com.ssm.entity.Student;
import com.ssm.entity.circular;

public interface StudentService {

	public boolean verifyCustomer(int admnNo,LocalDate dob);
	public Marks viewMarks(int admnNo,Exams exam);
	public Student stuDetails(int admnNo);
	public double calculateTotal(int admnNo,Exams exam);
	public int calculateRank(int admnNo,Exams exam);
	public Long noOfStuInStd(int std);
	public double viewBalance(int admnNo);
	public Exams StringtoExams(String exam);
	public double changeBalance(int admnNo,double newBalance);
	public String BloodGroupToString(BloodGroup b);
	public List<String> viewGalleryPics(int category);
	public List<circular> viewCirculars();
	public String categoryConversion(int category);

}
