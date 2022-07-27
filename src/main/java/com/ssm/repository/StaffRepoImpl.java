package com.ssm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ssm.dto.MarksDto;
import com.ssm.entity.Exams;
import com.ssm.entity.Marks;
import com.ssm.entity.Staff;
import com.ssm.entity.Student;

@Repository
public class StaffRepoImpl implements StaffRepo{

	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public boolean verifyStaff(int staffId, String password) {
		String jpql = "select count(s) from Staff s where s.StaffId=:id and s.password=:pwd";
		Query query = em.createQuery(jpql);
		query.setParameter("id", staffId);
		query.setParameter("pwd", password);
		Long count = (Long) query.getSingleResult();

		return count == 1 ? true : false;	
	}
	

	@Override
	public Staff getStaff(int staffId) {
		return em.find(Staff.class, staffId);
	}

	
	@Override
	public List<Marks> viewStudentsMarks(int standard, char section, Exams exam) {
		String jpql="select m from Marks m where m.exam=:ex and m.student.standard=:std and m.student.section=:sec";
		TypedQuery<Marks> query=em.createQuery(jpql, Marks.class);
		query.setParameter("ex", exam);
		query.setParameter("std", standard);
		query.setParameter("sec", section);
		return query.getResultList();
	}

	@Override
	@Transactional
	public Marks updateStudentMarks(Marks m) {
		return em.merge(m);
	}

	@Override
	public List<Student> viewStudents(int standard, char Section) {
		return em.createQuery("select s from Student s where s.standard = :std and s.section = :sec order by s.name")
				.setParameter("std", standard)
				.setParameter("sec", Section)
				.getResultList();
	}

	@Override
	public Student findStudentByAdmnNo(int admnNo) {
		return em.find(Student.class, admnNo);
	}


	@Override
	@Transactional
	public Marks uploadMarks1(int admnNo, Exams exam, String sub, double marks) {
		Marks mark=null;
		try {
			mark=(Marks) em.createQuery("select m from Marks m where m.student.admnNo = : ad and m.exam =:ex")
					.setParameter("ad", admnNo)
					.setParameter("ex", exam)
					.getSingleResult();
		}
		
		catch(NoResultException e)
		{
			if(mark==null) {
				System.out.println(mark);
				mark=new Marks();
				mark.setExam(exam);
				Student s=findStudentByAdmnNo(admnNo);
				mark.setStudent(s);
			}
			
			
		}
		//System.out.println(mark);
		finally {
			String jpql="";
			if(sub=="English") 
				mark.setSub1(marks);
			else if(sub=="Tamil" || sub=="Hindi" || sub=="Physics")
				mark.setSub2(marks);
			else if(sub=="Maths" || sub=="Accountancy")
				mark.setSub3(marks);
			else if(sub=="Science"||sub=="Chemistry"||sub=="Economics")
				mark.setSub4(marks);
			
			else if(sub=="Maths" || sub=="Accountancy")
				jpql="update Marks m set m.sub3=: marks where m.student.admnNo=:ad and m.exam=:ex";
			else if(sub=="Science"||sub=="Chemistry"||sub=="Business Maths")
				jpql="update Marks m set m.sub4=: marks where m.student.admnNo=:ad and m.exam=:ex";
			else if(sub=="Social" || sub=="Biology" || sub=="Economics")
				jpql="update Marks m set m.sub5=: marks where m.student.admnNo=:ad and m.exam=:ex";
			
			
			else
				mark.setSub5(marks);
			System.out.println(mark);
			return em.merge(mark);
		}
		}


	@Override
	public boolean findMarks(int admnNo, Exams exam) {
		String jpql="select count(m) from Marks m where m.student.admnNo=:ad and m.exam=:ex";
		Query query=em.createQuery(jpql);
		query.setParameter("ad", admnNo);
		query.setParameter("ex", exam);
		Long count=(Long)query.getSingleResult();
		System.out.println(count);
		return count>0?true:false;
	}


	@Override
	@Transactional
	public int updateMarks(int admnNo, Exams exam, String sub, double marks) {
		String jpql="";
		switch(sub) {
		case "English":
			jpql="update Marks m set m.sub1=: marks where m.student.admnNo=:ad and m.exam=:ex";
			break;
		
		case "Tamil":
			jpql="update Marks m set m.sub2=: marks where m.student.admnNo=:ad and m.exam=:ex";
			break;
		case "Hindi":
			jpql="update Marks m set m.sub2=: marks where m.student.admnNo=:ad and m.exam=:ex";
			break;
		case "Physics":
			jpql="update Marks m set m.sub3=: marks where m.student.admnNo=:ad and m.exam=:ex";
			break;
		case "Maths":
			jpql="update Marks m set m.sub3=: marks where m.student.admnNo=:ad and m.exam=:ex";
			break;
		case "Accountancy":
			jpql="update Marks m set m.sub3=: marks where m.student.admnNo=:ad and m.exam=:ex";
			break;
		case "Science":
			jpql="update Marks m set m.sub4=: marks where m.student.admnNo=:ad and m.exam=:ex";
			break;
		case "Chemistry":
			jpql="update Marks m set m.sub4=: marks where m.student.admnNo=:ad and m.exam=:ex";
			break;
		case "Business Maths":
			jpql="update Marks m set m.sub4=: marks where m.student.admnNo=:ad and m.exam=:ex";
			break;
		default:
			jpql="update Marks m set m.sub5=: marks where m.student.admnNo=:ad and m.exam=:ex";
			break;
		}
		Query query=em.createQuery(jpql);
		query.setParameter("marks", marks);
		query.setParameter("ad", admnNo);
		query.setParameter("ex", exam);
		int n=query.executeUpdate();
		return n;
	}


	@Override
	@Transactional
	public Marks addMarks(Marks m) {
		return em.merge(m);
	}


	@Override
	public Marks getMarks(int admnNo, Exams exam) {
		String jpql="select m from Marks m where m.student.admnNo=:ad and m.exam=:ex";
		Query query=em.createQuery(jpql);
		query.setParameter("ad", admnNo);
		query.setParameter("ex", exam);
		return (Marks) query.getSingleResult();
	}

	

}
