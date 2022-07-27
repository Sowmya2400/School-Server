package com.ssm.service;

import com.ssm.entity.Gallery;
import com.ssm.entity.Staff;
import com.ssm.entity.Student;
import com.ssm.entity.circular;

public interface AdminService {
	public Student addUpdateStudent(Student s);
	public Staff addUpdateStaff(Staff s);
	public Student get(int admnNo);
	public Gallery uploadImages(Gallery g);
	public circular uploadCircular(circular c);
}
