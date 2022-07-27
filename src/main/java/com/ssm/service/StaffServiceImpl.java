package com.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dto.MarksDto;
import com.ssm.entity.Exams;
import com.ssm.entity.Marks;
import com.ssm.entity.Staff;
import com.ssm.entity.Student;
import com.ssm.entity.Subjects;
import com.ssm.repository.StaffRepo;

@Service
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	StaffRepo repo;
	
	@Override
	public boolean verifyStaff(int staffId, String password) {
		return repo.verifyStaff(staffId, password);
	}
	
	@Override
	public Staff getStaff(int staffId) {
		return repo.getStaff(staffId);
	}

	@Override
	public List<Marks> viewStudentsMarks(int standard, char Section, Exams exam) {
		return repo.viewStudentsMarks(standard, Section, exam);
	}

	@Override
	public Marks updateStudentMarks(Marks m) {
		return repo.updateStudentMarks(m);
	}

	@Override
	public List<Student> viewStudents(int standard, char Section) {
		return repo.viewStudents(standard, Section);
	}

	@Override
	public Student findStudentByAdmnNo(int admnNo) {
		return repo.findStudentByAdmnNo(admnNo);
	}
	
	@Override
	public Exams StringtoExams(String e) {
		Exams exam = null;
		switch (e) {
		case "Term1":
			exam = Exams.TermI;
			break;
		case "Term2":
			exam = Exams.TermII;
			break;
		case "MidTerm1":
			exam = Exams.MidTermI;
			break;
		case "MidTerm2":
			exam = Exams.MidTermII;
			break;
		}
		return exam;
	}

	@Override
	public Subjects StringtoSubjects(String subject) {
		Subjects sub=null;
		switch (subject) {
		case "English":
			sub=Subjects.English;
			break;
		case "Tamil":
			sub=Subjects.Tamil;
			break;
		case "Hindi":
			sub=Subjects.Hindi;
			break;
		case "Maths":
			sub=Subjects.Maths;
			break;
		case "Science":
			sub=Subjects.Science;
			break;
		case "Social Science":
			sub=Subjects.Social;
			break;
		case "Biology":
			sub=Subjects.Biology;
			break;
		case "Physics":
			sub=Subjects.Physics;
			break;
		case "Chemistry":
			sub=Subjects.Chemistry;
			break;
		case "Computer Science":
			sub=Subjects.ComputerScience;
			break;
		case "Accountancy":
			sub=Subjects.Accountancy;
			break;
		case "Business Maths":
			sub=Subjects.BusinessMaths;
			break;
		case "Economics":
			sub=Subjects.Economics;
			break;
		default:
			break;
		}
		return sub;
	}

	@Override
	public String SubjectsToString(Subjects subject) {
	
		return null;
	}


	@Override
	public Marks uploadMarks1(int admnNo, Exams exam, String sub, double marks) {
		return repo.uploadMarks1(admnNo, exam, sub, marks);
	}

	@Override
	public boolean findMarks(int admnNo, Exams exam) {
		return repo.findMarks(admnNo, exam);
	}

	@Override
	public int updateMarks(int admnNo, Exams exam, String sub, double marks) {
		return repo.updateMarks(admnNo, exam, sub, marks);
	}

	@Override
	public Marks addMarks(Marks m) {
		return repo.addMarks(m);
	}

	@Override
	public int subToInt(String sub) {
		int n;
		switch(sub) {
		case "English":
			n=1;
			break;
		
		case "Tamil":
			n=2;
			break;
		case "Hindi":
			n=2;
			break;
		case "Physics":
			n=3;
			break;
		case "Maths":
			n=3;
			break;
		case "Accountancy":
			n=3;
			break;
		case "Science":
			n=4;
			break;
		case "Chemistry":
			n=4;
			break;
		case "Business Maths":
			n=4;
			break;
		default:
			n=5;
			break;
		}
		return n;
	}

	@Override
	public Marks getMarks(int admnNo, Exams exam) {
		return repo.getMarks(admnNo, exam);
	}


}
