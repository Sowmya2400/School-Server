package com.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.entity.Gallery;
import com.ssm.entity.Staff;
import com.ssm.entity.Student;
import com.ssm.entity.circular;
import com.ssm.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService{

	
	@Autowired
	AdminRepo repo;
	@Override
	public Student addUpdateStudent(Student s) {
		return repo.addUpdateStudent(s) ;
	}

	@Override
	public Staff addUpdateStaff(Staff s) {
		return repo.addUpdateStaff(s);
	}

	@Override
	public Student get(int admnNo) {
		return repo.get(admnNo);
	}

	@Override
	public Gallery uploadImages(Gallery g) {
		return repo.uploadImgsinGallery(g);
	}

	@Override
	public circular uploadCircular(circular c) {
		return repo.uploadCircular(c);
	}

}
