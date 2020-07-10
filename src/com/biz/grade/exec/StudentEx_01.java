package com.biz.grade.exec;

import com.biz.grade.service.StudentService;
import com.biz.grade.service.StudentServiceImplV1;

public class StudentEx_01 {
	
	public static void main(String[] args) {
		
		
		StudentService sService = new StudentServiceImplV1();
		
		while(true) {
			if(!sService.inputStudent()) {
				break;
			}
		}
		sService.studentList();
	
		
	}

}
