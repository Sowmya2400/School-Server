package com.ssm.repository;



import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ssm.entity.Gallery;
import com.ssm.entity.Staff;
import com.ssm.entity.Student;
import com.ssm.entity.circular;

@Service
public interface AdminRepo {
	public Student addUpdateStudent(Student s);
	public Staff addUpdateStaff(Staff s);
	public Student get(int admnNo);
	public Gallery uploadImgsinGallery(Gallery g);
	public circular uploadCircular(circular c);
	
}
