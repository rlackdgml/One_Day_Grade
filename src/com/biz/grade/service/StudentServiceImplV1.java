package com.biz.grade.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.grade.vo.StudentVO;

public class StudentServiceImplV1 implements StudentService {

	protected List<StudentVO> studentList;

	public StudentServiceImplV1() {

		studentList = new ArrayList<StudentVO>();
	}

	public boolean inputStudent() {

		StudentVO stdVO = new StudentVO();

		Scanner scan = new Scanner(System.in);
		System.out.print("학번(END:입력중단) >>");
		String strNum = scan.nextLine();
		if (strNum.equals("END")) {
			return false;
		}
		stdVO.setNum(strNum);

		System.out.print("이름>>");
		String strName = scan.nextLine();
		stdVO.setName(strName);

		System.out.print("학과>>");
		String strDepartment = scan.nextLine();
		stdVO.setDepartment(strDepartment);

		System.out.print("학년>>");
		String strGrade = scan.nextLine();
		stdVO.setGrade(Integer.valueOf(strGrade));

		int intGrade = 0;

		try {
			intGrade = Integer.valueOf(strGrade);
		} catch (Exception e) {
			System.out.println("학년숫자만 가능");
			System.out.println(stdVO.getGrade() + "학생정보를 다시 입력해 주세요");
			return true;
		}
		if (intGrade < 1 || intGrade > 4) {
			System.out.println("학년은 1 ~ 4까지만 가능");
			System.out.println(stdVO.getGrade() + "학생정보를 다시 입력해 주세요");
			return true;
			
			

		}
		
		System.out.print("전화번호 >>");
		String strTel = scan.nextLine();
		stdVO.setTel(strTel);
		

		stdVO.setGrade(intGrade);

		studentList.add(stdVO);

		return true;

	}

	public void studentList() {
		
		for (StudentVO sVO : studentList) {

			System.out.print(sVO.getNum() + ":");
			System.out.print(sVO.getName() + ":");
			System.out.print(sVO.getDepartment() + ":");
			System.out.print(sVO.getGrade() + ":");
			System.out.println(sVO.getTel());

		}
		System.out.println();

	}

}
