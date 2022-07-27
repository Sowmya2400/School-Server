 package com.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssm.dto.MarksDto;
import com.ssm.dto.StaffLoginDto;
import com.ssm.dto.StaffMarksDto;
import com.ssm.dto.StudentLoginDto;
import com.ssm.dto.viewStaffDto;
import com.ssm.entity.Exams;
import com.ssm.entity.Marks;
import com.ssm.entity.Staff;
import com.ssm.entity.Student;
import com.ssm.service.EmailService;
import com.ssm.service.StaffService;

@RestController
@CrossOrigin
public class StaffController {
	
	@Autowired
	StaffService service;
	
	@Autowired
	EmailService emailService;
	
	//http://localhost:9095/staff-login
		@PostMapping(path = "/staff-login")
		Map<String, Object> login(@RequestBody StaffLoginDto logindto) {
			HashMap<String, Object> response = new HashMap<>();
			try {
				if (service.verifyStaff(logindto.getStaffId(), logindto.getPassword())) {
					Staff s=service.getStaff(logindto.getStaffId());
					response.put("name", s.getName());
					response.put("Std1", s.getStandard1());
					response.put("Std2", s.getStandard2());
					response.put("Std3", s.getStandard3());
					response.put("Sec1", s.getSection1());
					response.put("Sec2", s.getSection2());
					response.put("Sec3", s.getSection3());
					response.put("Sub1", s.getSubject1());
					response.put("Sub2", s.getSubject2());
					response.put("Sub3", s.getSubject3());
					response.put("Class1", s.getStandard1()+" - "+s.getSection1()+"  "+s.getSubject1());
					response.put("Class2", s.getStandard2()+" - "+s.getSection2()+"  "+s.getSubject2());
					response.put("Class3", s.getStandard3()+" - "+s.getSection3()+"  "+s.getSubject3());
					response.put("Response", "OK");
				} else {
					response.put("Response", "INCORRECT");
				}
			} catch (Exception e) {
				e.printStackTrace();
				response.put("Response", "FAILED");
			}
			return response;
		}
		
	
	//http://localhost:9095/updateMarks
	@PostMapping(value = "/updateMarks")
	public Marks updateMarks(@RequestBody MarksDto m) {
		Exams exam=service.StringtoExams(m.getExam());
		Marks mark=new Marks(exam, m.getSub1(), m.getSub2(), m.getSub3(), m.getSub4(), m.getSub5());
		Student stu=service.findStudentByAdmnNo(m.getAdmnNo());
		List<Marks> marks=stu.getMarks();
		for(Marks mar:marks) {
			if(mar.getExam()==exam) {
				mark.setId(mar.getId());
			}
		}

		mark.setStudent(stu);
		String text="Marks have been uploaded for your ward for the "+m.getExam()+" exam. Please visit our school website for viewing the results";
		return service.updateStudentMarks(mark);
	}
	
	//http://localhost:9095/viewMarks/10/B/Term1
	@PostMapping(value="/viewMarks/{standard}/{section}/{exam}")
	public Map<String,Object>  viewMarks(@PathVariable("exam") String examName,@PathVariable("standard") int standard,@PathVariable("section") char section){
		HashMap<String, Object> response=new HashMap<>();
		Exams exam=service.StringtoExams(examName);
		List<Marks> marksList=service.viewStudentsMarks(standard, section,exam);
		List<Object> marks=new ArrayList<>();
		for(Marks m:marksList) {
			List<Object> t=new ArrayList<>();
			t.add(m.getStudent().getAdmnNo());
			t.add(m.getStudent().getName());
			t.add(m.getSub1());
			t.add(m.getSub2());
			t.add(m.getSub3());
			t.add(m.getSub4());
			t.add(m.getSub5());
			marks.add(t);
		}
		response.put("Marks", marks);
		return response;
	}

	
	//http://localhost:9095/viewStudents
	@PostMapping(value = "/viewStudents")
	public Map<String,Object> viewStudents(@RequestBody viewStaffDto dto){
		HashMap<String, Object> response=new HashMap<>();
		List<Student> studentsList=service.viewStudents(dto.getStandard(), dto.getSection());
		List<Object> students=new ArrayList<>();
		Exams exam=service.StringtoExams(dto.getExam());
		int n=service.subToInt(dto.getSub());
		for(Student s:studentsList) {
			List<Object> t=new ArrayList<>();
			t.add(s.getAdmnNo());
			t.add(s.getName());
			if(service.findMarks(s.getAdmnNo(), exam))
			{
				Marks m=service.getMarks(s.getAdmnNo(), exam);
				if(n==1) 
					t.add(m.getSub1());
				else if(n==2)
					t.add(m.getSub2());
				else if(n==3)
					t.add(m.getSub3());
				else if(n==4)
					t.add(m.getSub4());
				else
					t.add(m.getSub5());
			}
			else {
				t.add(0.0);
			}
			t.add(s.getStandard());
			t.add(s.getAddress());
			t.add(s.getBalance());
			t.add(s.getBloodGroup());
			t.add(s.getDob());
			t.add(s.getEmailId());
			t.add(s.getPhoto());
			t.add(s.getSection());
			students.add(t);
			System.out.println(t);
		}
		response.put("Length", students.size());
		response.put("Students", students);
		return response;
	}
	
	//http://localhost:9095/uploadMarks
	@PostMapping(value = "/uploadMarks")
	public Map<String,Object> uploadMarks(@RequestBody StaffMarksDto dto){
		HashMap<String, Object> response=new HashMap<>();
		Exams exam=service.StringtoExams(dto.getExam());
		Student stu=service.findStudentByAdmnNo(dto.getAdmnNo());
		if(service.findMarks(dto.getAdmnNo(), exam)==false) {
			try {
			Marks mark=new Marks();
			mark.setExam(exam);
			Student s=service.findStudentByAdmnNo(dto.getAdmnNo());
			mark.setStudent(s);
			int n=service.subToInt(dto.getSub());
			if(n==1) 
				mark.setSub1(dto.getMark());
			else if(n==2)
				mark.setSub2(dto.getMark());
			else if(n==3)
				mark.setSub3(dto.getMark());
			else if(n==4)
				mark.setSub4(dto.getMark());
			else
				mark.setSub5(dto.getMark());
			
			Marks m=service.addMarks(mark);
			if(m.getId()>0)response.put("Done","Yes");
			}
			catch(IllegalStateException e) {
				System.out.println("Http exception");
			}
		}
		else {
			int n=service.updateMarks(dto.getAdmnNo(), exam, dto.getSub(),dto.getMark());
			if(n==1)response.put("Done", "Yes");
		}
		String text="Marks have been uploaded for your ward for the "
		             +dto.getExam()+" exam. Please visit our school website for viewing the results";
		try {
			emailService.sendEmailForMarksUpload(stu.getEmailId(),"Marks Uploaded",text);
		} catch (MessagingException e) {
			System.out.println("Exception");
		}
		return response;
	}

}
