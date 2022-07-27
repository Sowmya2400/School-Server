package com.ssm.repository;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssm.entity.BloodGroup;
import com.ssm.entity.Gallery;
import com.ssm.entity.Staff;
import com.ssm.entity.Student;
import com.ssm.entity.circular;

@Repository
public class AdminRepoImpl implements AdminRepo {

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public Student addUpdateStudent(Student s) {
		return em.merge(s);
	}

	@Override
	@Transactional
	public Staff addUpdateStaff(Staff s) {
		return em.merge(s);
	}

	@Override
	public Student get(int admnNo) {
		return em.find(Student.class, admnNo);
	}

	@Override
	@Transactional
	public Gallery uploadImgsinGallery(Gallery g) {
		return em.merge(g);
	}

	@Override
	@Transactional
	public circular uploadCircular(circular c) {
		return em.merge(c);
	}

}
