package com.ssm.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.entity.BloodGroup;
import com.ssm.entity.Exams;
import com.ssm.entity.Marks;
import com.ssm.entity.Student;
import com.ssm.entity.circular;
import com.ssm.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepo repo;
	
	
	@Override
	public boolean verifyCustomer(int admnNo, LocalDate dob) {
		return repo.verifyCustomer(admnNo, dob);
	}

	@Override
	public Marks viewMarks(int admnNo, Exams exam) {
		return repo.viewMarks(admnNo, exam);
	}

	@Override
	public Student stuDetails(int admnNo) {
		return repo.stuDetails(admnNo);
	}

	@Override
	public int calculateRank(int admnNo, Exams exam) {
		return repo.calculateRank(admnNo, exam);
	}
	@Override
	public double calculateTotal(int admnNo, Exams exam) {
		return repo.calculateTotal(admnNo, exam);
	}

	@Override
	public Long noOfStuInStd(int std) {
		return repo.noOfStuInStd(std);
	}

	@Override
	public double viewBalance(int admnNo) {
		return repo.viewBalance(admnNo);
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
	public double changeBalance(int admnNo, double newBalance) {
		return repo.changeBalance(admnNo, newBalance);
	}

	@Override
	public String BloodGroupToString(BloodGroup b) {
		String blood=null;
		if(b==BloodGroup.A0)blood="A -ve";
		else if(b==BloodGroup.A1)blood="A +ve";
		else if(b==BloodGroup.B0)blood="B -ve";
		else if(b==BloodGroup.B1)blood="B +ve";
		else if(b==BloodGroup.AB0)blood="AB -ve";
		else if(b==BloodGroup.AB1)blood="AB +ve";
		else if(b==BloodGroup.O0)blood="O -ve";
		else if(b==BloodGroup.O1)blood="O +ve";
		else blood="Undefined";
		return blood;
	}

	@Override
	public List<String> viewGalleryPics(int category) {
		return repo.viewGalleryPics(category);
	}

	@Override
	public List<circular> viewCirculars() {
		return repo.viewCirculars();
	}

	@Override
	public String categoryConversion(int category) {
		String cat="";
		switch(category) {
		case 1:cat="Class I";break;
		case 2:cat="Class II";break;
		case 3:cat="Class III";break;
		case 4:cat="Class IV";break;
		case 5:cat="Class V";break;
		case 6:cat="Class VI";break;
		case 7:cat="Class VII";break;
		case 8:cat="Class VIII";break;
		case 9:cat="Class IX";break;
		case 10:cat="Class X";break;
		case 11:cat="Class XI";break;
		case 12:cat="Class XII";break;
		case 13:cat="Classes I to XII";break;
		case 14:cat="Classes I & II";break;
		case 15:cat="Classes III to V";break;
		case 16:cat="Classes VI to VII";break;
		case 17:cat="Classes IX & X";break;
		case 18:cat="Classes XI & XII";break;
		case 19:cat="Classes IX to XII";break;
		case 20:cat="Classes VI to XII";break;
		}
		return cat;
	}

}
