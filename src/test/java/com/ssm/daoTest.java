package com.ssm;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.entity.BloodGroup;
import com.ssm.entity.Student;
import com.ssm.repository.AdminRepo;
import com.ssm.repository.AdminRepoImpl;

class daoTest {

	@Autowired
	private AdminRepo ad;
	@Test
	void testaddUpdateStudent() {
		
/*		"email":"muraliakg@yahoo.com",
		   "name":"Gokul",
		   "standard":10,
		   "section":"B",
		   "address":"Chromepet",
		   "balance":0.0,
		   "bloodgroup":"O-",
		   "dob":"2006-10-22" 
*/
		
		
/*
 "name":"Geetha",
  "standard1":10,
  "section1":"B",
  "subject1":"Maths",
  "standard2":10,
  "section2":"A",
  "subject2":"Chemistry",
  "standard3":12,
  "section3":"A",
  "subject3":"Chemistry",
  "password":"123Ugofree"
 */
		
/*
 
  "exam":"Term1",
  "sub1":92.0,
  "sub2":98.0,
  "sub3":97.0,
  "sub4":99.0,
  "sub5":95.0,
  "admnNo":1001
 */

	}

}
