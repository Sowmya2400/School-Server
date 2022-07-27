package com.ssm.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssm.dto.GalleryPicDto;
import com.ssm.dto.ProfilePicDto;
import com.ssm.dto.Status;
import com.ssm.dto.Status.StatusType;
import com.ssm.dto.StudentDto;
import com.ssm.dto.circularDto;
import com.ssm.entity.BloodGroup;
import com.ssm.entity.Gallery;
import com.ssm.entity.Staff;
import com.ssm.entity.Student;
import com.ssm.entity.circular;
import com.ssm.service.AdminService;



@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	AdminService service;
	
	
	//http://localhost:9095/addStudent
	@PostMapping(value="/addStudent")
	public Student addStudent(@RequestBody StudentDto stu) {
		Student student=new Student();
		student.setName(stu.getName());
		student.setAddress(stu.getAddress());
		student.setBalance(stu.getBalance());
		student.setDob(LocalDate.parse(stu.getDob()));
		student.setEmailId(stu.getEmail());
		student.setSection(stu.getSection());
		student.setStandard(stu.getStandard());
		switch(stu.getBloodgroup()) {
		case "O-":student.setBloodGroup(BloodGroup.O0);break;
		case "O+":student.setBloodGroup(BloodGroup.O1);break;
		case "A-":student.setBloodGroup(BloodGroup.A0);break;
		case "A+":student.setBloodGroup(BloodGroup.A1);break;
		case "B-":student.setBloodGroup(BloodGroup.B0);break;
		case "B+":student.setBloodGroup(BloodGroup.B1);break;
		case "AB-":student.setBloodGroup(BloodGroup.AB0);break;
		case "AB+":student.setBloodGroup(BloodGroup.AB1);break;
		}
		return service.addUpdateStudent(student);
	}
	
	
	//http://localhost:9095/SSM_School/addStaff
	@PostMapping(value = "/addStaff")
	public Staff addUpdateStaff(@RequestBody Staff staff) {
		return service.addUpdateStaff(staff);
	}
	
	
	//http://localhost:9095/stuPic-upload
	@PostMapping("/stuPic-upload")
	public Status upload(ProfilePicDto profilePicDto) {
		String imageUploadLocation = "e:/Mini Projects/School Website/Client/ssmschool/src/assets/profile/";
		String fileName = profilePicDto.getProfilePic().getOriginalFilename();
		String targetFile = imageUploadLocation + fileName;
		try {
			FileCopyUtils.copy(profilePicDto.getProfilePic().getInputStream(), new FileOutputStream(targetFile));
		} catch (IOException e) {
			e.printStackTrace();
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
		Student student=service.get(profilePicDto.getAdmnNo());
		student.setPhoto(fileName);
		service.addUpdateStudent(student);
		
		Status status = new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Uploaded!");
		return status;
	}

	//http://localhost:9095/galleryPic-upload
	@PostMapping(value = "/galleryPic-upload")
	public Status galleryUpload(GalleryPicDto galleryPicDto) {
		//d:/ssm/gallery/
		String imageUploadLocation = "e:/Mini Projects/School Website/Client/ssmschool/src/assets/gallery/";
		String fileName = galleryPicDto.getGalleryPic().getOriginalFilename();
		String targetFile = imageUploadLocation + fileName;
		try {
			FileCopyUtils.copy(galleryPicDto.getGalleryPic().getInputStream(), new FileOutputStream(targetFile));
		} catch (IOException e) {
			e.printStackTrace();
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
		Gallery g=new Gallery(galleryPicDto.getCategory(),fileName);
		service.uploadImages(g);
		
		Status status = new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Uploaded!");
		return status;
	}
	
	
	//http://localhost:9095/upload-Circular
	@PostMapping(value = "/upload-Circular")
	public Status circularUpload (circularDto dto){
		
		String imageUploadLocation = "e:/Mini Projects/School Website/Client/ssmschool/src/assets/circular/";
		String fileName = dto.getCircularFile().getOriginalFilename();
		String targetFile = imageUploadLocation + fileName;
		try {
			FileCopyUtils.copy(dto.getCircularFile().getInputStream(), new FileOutputStream(targetFile));
		} catch (IOException e) {
			e.printStackTrace();
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
		circular c=new circular(dto.getCircular_Category(), dto.getCircular_Date(),dto.getCircular_Subject(),fileName);
		service.uploadCircular(c);
		
		Status status = new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Uploaded!");
		return status;
	}
	
	

}
