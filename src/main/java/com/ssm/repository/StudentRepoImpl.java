package com.ssm.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ssm.entity.Exams;
import com.ssm.entity.Marks;
import com.ssm.entity.Student;
import com.ssm.entity.circular;

@Repository
public class StudentRepoImpl implements StudentRepo{

	@PersistenceContext
	EntityManager em;
	
	

	@Override
	public boolean verifyCustomer(int admnNo, LocalDate dob) {
		String jpql = "select count(s) from Student s where s.admnNo=:ad and s.dob=:d";
		Query query = em.createQuery(jpql);
		query.setParameter("ad", admnNo);
		query.setParameter("d", dob);
		Long count = (Long) query.getSingleResult();

		return count == 1 ? true : false;
	}


	@Override
	public Marks viewMarks(int admnNo, Exams exam) {
		Student s=em.find(Student.class, admnNo);
		List<Marks> m=s.getMarks();
		Marks mark=null;
		if(m!=null) {
			for(Marks ml : m) {
				if(ml.getExam()==exam) {
					mark=ml;
					break;
				}
			}
		}
		return mark;
	}

	@Override
	public Student stuDetails(int admnNo) {
		return em.find(Student.class, admnNo);
	}

	@Override
	public Long noOfStuInStd(int standard) {
		return (Long)em
				.createQuery("select count(s.admnNo) from Student s where s.standard = :std")
				.setParameter("std", standard)
				.getSingleResult();
	}

	@Override
	public double calculateTotal(int admnNo,Exams exam) {
		Marks mark=viewMarks(admnNo, exam);
		return mark.getSub1()+mark.getSub2()+mark.getSub3()+mark.getSub4()+mark.getSub5();
	}
	
	@Override
	public double calculateTotalMarks(Marks mark) {
		return mark.getSub1()+mark.getSub2()+mark.getSub3()+mark.getSub4()+mark.getSub5();	
	}

	@Override
	public int calculateRank(int admnNo,Exams exam) {
		double total=calculateTotal(admnNo, exam);
		double tot=0;
		int rank=1;
		List<Double> totals=new ArrayList<>();
		int standard=em.find(Student.class, admnNo).getStandard();
		Long noOfStu=noOfStuInStd(standard);
		List<Marks> marks=(List<Marks>) em
				.createQuery("select m from Marks m where m.exam = :ex and m.student.standard=:std")
				.setParameter("ex", exam)
				.setParameter("std", standard)
				.getResultList();
		for(Marks m:marks) {
			tot=0;
			tot=calculateTotalMarks(m);
			totals.add(tot);
		}
		for(double t:totals) {
			if(t>total) rank++;
		}
		return rank;
	}

	@Override
	public double viewBalance(int admnNo) {
		return em.find(Student.class, admnNo).getBalance();
	}

	@Override
	@Transactional
	public double changeBalance(int admnNo, double newBalance) {
		String jpql="update Student s set s.balance=:bal where s.admnNo=:ad";
		Query query=em.createQuery(jpql);
		query.setParameter("ad", admnNo);
		query.setParameter("bal", newBalance);
		int n=query.executeUpdate();
		return viewBalance(admnNo);
	}
	
	@Override
	public List<String> viewGalleryPics(int category) {
		return (List<String>)em.createQuery("select g.image from Gallery g where g.category = :cat")
				            .setParameter("cat", category)
				            .getResultList();
	}

	@Override
	public List<circular> viewCirculars() {
		return (List<circular>) em.createQuery("select c from circular c")
									.getResultList();
	}

}
