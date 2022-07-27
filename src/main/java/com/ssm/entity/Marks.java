package com.ssm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ssm_marks")
public class Marks {
	
	@Id
	@SequenceGenerator(name="mark_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "mark_seq")
	private int id;
	private Exams exam;
	private double sub1;
	private double sub2;
	private double sub3;
	private double sub4;
	private double sub5;
	
	@ManyToOne
	@JoinColumn(name="admnNo")
	Student student;

	public Marks() {
		super();
	}

	public Marks(Exams exam, double sub1, double sub2, double sub3, double sub4, double sub5) {
		super();
		this.exam = exam;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		this.sub4 = sub4;
		this.sub5 = sub5;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Exams getExam() {
		return exam;
	}

	public void setExam(Exams exam) {
		this.exam = exam;
	}

	public double getSub1() {
		return sub1;
	}

	public void setSub1(double sub1) {
		this.sub1 = sub1;
	}

	public double getSub2() {
		return sub2;
	}

	public void setSub2(double sub2) {
		this.sub2 = sub2;
	}

	public double getSub3() {
		return sub3;
	}

	public void setSub3(double sub3) {
		this.sub3 = sub3;
	}

	public double getSub4() {
		return sub4;
	}

	public void setSub4(double sub4) {
		this.sub4 = sub4;
	}

	public double getSub5() {
		return sub5;
	}

	public void setSub5(double sub5) {
		this.sub5 = sub5;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Marks [id=" + id + ", exam=" + exam + ", sub1=" + sub1 + ", sub2=" + sub2 + ", sub3=" + sub3 + ", sub4="
				+ sub4 + ", sub5=" + sub5 + ", student=" + student + "]";
	}
	


	
	
	
	
}
