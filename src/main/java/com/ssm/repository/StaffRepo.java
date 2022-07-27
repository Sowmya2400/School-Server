package com.ssm.repository;

import java.util.List;

import com.ssm.dto.MarksDto;
import com.ssm.entity.Exams;
import com.ssm.entity.Marks;
import com.ssm.entity.Staff;
import com.ssm.entity.Student;

public interface StaffRepo {
	public boolean verifyStaff(int staffId,String password);
	public Staff getStaff(int staffId);
	public List<Marks> viewStudentsMarks(int standard,char Section,Exams exam);
	public Marks updateStudentMarks(Marks m);
	public List<Student> viewStudents(int standard,char Section);
	public Student findStudentByAdmnNo(int admnNo);
	
	public Marks uploadMarks1(int admnNo,Exams exam,String sub,double marks);
	
	public boolean findMarks(int admnNo,Exams exam);
	public int updateMarks(int admnNo,Exams exam,String sub,double marks);
	public Marks addMarks(Marks m);
	public Marks getMarks(int admnNo,Exams exam);
}
