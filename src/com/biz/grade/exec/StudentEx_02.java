package com.biz.grade.exec;

import com.biz.grade.service.StudentService;
import com.biz.grade.service.StudentServiceImplV2;

public class StudentEx_02 {

	public static void main(String[] args) {

		

		StudentService sService = new StudentServiceImplV2();
		
		while(true) {
			if(!sService.inputStudent()) {
				break;
			}
		}
		sService.studentList();
	}

}

//00001:홍길동:컴퓨터공학:3:010-111-1111 (순서대로 학번:이름:학과:학년:전화번호)
