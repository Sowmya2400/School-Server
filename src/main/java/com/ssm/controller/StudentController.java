package com.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssm.dto.GalleryPicDto;
import com.ssm.dto.MarksDto;
import com.ssm.dto.StudentDto;
import com.ssm.dto.StudentLoginDto;
import com.ssm.dto.circularDto;
import com.ssm.entity.Exams;
import com.ssm.entity.Marks;
import com.ssm.entity.Student;
import com.ssm.entity.circular;
import com.ssm.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {

	@Autowired
	StudentService service;

	//http://localhost:9095/login
	@PostMapping(path = "/login")
	Map<String, Object> login(@RequestBody StudentLoginDto logindto) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			if (service.verifyCustomer(logindto.getAdmnNo(), logindto.getDob())) {
				Student s=service.stuDetails(logindto.getAdmnNo());
				response.put("AdmnNo",s.getAdmnNo());
				response.put("Standard", s.getStandard());
				response.put("Address", s.getAddress());
				response.put("Balance", s.getBalance());
				response.put("DOB", s.getDob().toString());
				response.put("EmailId", s.getEmailId());
				response.put("Name", s.getName());
				response.put("Section", s.getSection());
				response.put("ImageFile", s.getPhoto());
				response.put("BloodGroup", service.BloodGroupToString(s.getBloodGroup()));
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
	
	@GetMapping("/test")
	String hello(){
		return "Working";
	}

	@PostMapping(value="/test1")
	String msg(){
		return "Hurrayy!!";
	}
	
	//http://localhost:9095/viewMarks
	@PostMapping(value = "/viewMarks")
	public Map<String, Object> viewMarks(@RequestBody MarksDto dto) {
		HashMap<String, Object> response = new HashMap<>();
		Exams exam=service.StringtoExams(dto.getExam());
		Marks mark = service.viewMarks(dto.getAdmnNo(), exam);
		if(mark!=null) {
			response.put("Updated", "Yes");
			response.put("Mark1", mark.getSub1());
			response.put("Mark2", mark.getSub2());
			response.put("Mark3", mark.getSub3());
			response.put("Mark4", mark.getSub4());
			response.put("Mark5", mark.getSub5());
			
			double total=service.calculateTotal(dto.getAdmnNo(), exam);
			response.put("Total", total);

			int rank=service.calculateRank(dto.getAdmnNo(), exam);
			response.put("Rank", rank);
			
			Student s=service.stuDetails(dto.getAdmnNo());
			Long stu=service.noOfStuInStd(s.getStandard());
			response.put("Strength", stu);
		}
		else response.put("Updated", "No");
		return response;
	}
	
	//http://localhost:9095/StudentDetails
	@PostMapping(value = "/StudentDetails")
	public Map<String,Object> viewStuDetails(@RequestBody StudentLoginDto dto){
		HashMap<String,Object> response=new HashMap<>();
		Student s=service.stuDetails(dto.getAdmnNo());
		response.put("AdmnNo",s.getAdmnNo());
		response.put("Standard", s.getStandard());
		response.put("Address", s.getAddress());
		response.put("Balance", s.getBalance());
		response.put("DOB", s.getDob().toString());
		response.put("EmailId", s.getEmailId());
		response.put("Name", s.getName());
		response.put("Section", s.getSection());
		response.put("BloodGroup", service.BloodGroupToString(s.getBloodGroup()));
		if(s.getPhoto()!=null) {
			String uploadedImagesPath = "d:/ssm/studentPhoto/";
			String sourceFile = uploadedImagesPath + s.getPhoto();
			response.put("ImagePath", sourceFile);
		}
		else response.put("ImagePath", "Undefined");
		response.put("Marks", s.getMarks());
		/*
		 * List<Object> t=new ArrayList<>(); t.add(s.getAdmnNo());
		 * t.add(s.getStandard()); t.add(s.getAddress()); t.add(s.getBalance());
		 * t.add(s.getBloodGroup()); t.add(s.getDob()); t.add(s.getEmailId());
		 * t.add(s.getName()); t.add(s.getPhoto()); t.add(s.getSection());
		 * response.put("Student", t);
		 */
		return response;
	}
	
	@PostMapping(value="/rank")
	public Map<String,Object> rankCalc(@RequestBody MarksDto dto){
		HashMap<String, Object> response=new HashMap<>();
		Exams exam=service.StringtoExams(dto.getExam());
		int rank=service.calculateRank(dto.getAdmnNo(), exam);
		response.put("Rank", rank);
		return response;
	}
	
	@PostMapping(value="/balance")
	public Map<String,Object> viewBalance(@RequestBody StudentLoginDto dto){
		HashMap<String, Object> response=new HashMap<String, Object>();
		double balance=service.viewBalance(dto.getAdmnNo());
		response.put("Balance", balance);
		return response;
	}
	
	@PostMapping(value="/payment")
	public Map<String,Object> changeBalance(@RequestBody StudentLoginDto dto){
		HashMap<String, Object> response=new HashMap<>();
		double balance=service.changeBalance(dto.getAdmnNo(), 0.0);
		response.put("Balance",balance);
		response.put("Payment", "Yes");
		return response;
	}
	
	//http://localhost:9095/gallery
	@PostMapping(value="/gallery")
	public Map<String,Object> viewGallery(@RequestBody GalleryPicDto dto){
		HashMap<String, Object> response=new HashMap<String, Object>();
		List<String> pics=service.viewGalleryPics(dto.getCategory());
		List<String> picsPath=new ArrayList<>();
		//d:/ssm/gallery/
		//e:/Mini Projects/School Website/Client/ssmschool/src/assests/img/
		String uploadedImagesPath = "assets/gallery/";
		for(String p:pics) {
			String path=uploadedImagesPath+p;
			picsPath.add(path);
		}
		response.put("Images", picsPath);
		return response;
	}
	
	//http://localhost:9095/circular
		@PostMapping(value="/circular")
		public Map<String,Object> viewCircular(){
			HashMap<String, Object> response=new HashMap<String, Object>();
			List<circular> circulars=service.viewCirculars();
			List<String> filePath=new ArrayList<>();
			List<String> categoryList=new ArrayList<>();
			List<String> dateList=new ArrayList<>();
			List<String> subjectList=new ArrayList<>();
			//String uploadedFilePath = "assets/circular/";
			for(circular c:circulars) {
				String path=c.getCircularFile();
				filePath.add(path);
				categoryList.add(service.categoryConversion(c.getCircular_Category()));
				dateList.add(c.getCircular_Date());
				subjectList.add(c.getCircular_Subject());
			}
			response.put("Files", filePath);
			response.put("Categories", categoryList);
			response.put("Dates", dateList);
			response.put("Subjects",subjectList);
			response.put("Circulars", circulars);
			response.put("Number",dateList.size());
			return response;
		}
	
}
