package com.biz.grade.service;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import com.biz.grade.vo.StudentVO;

public class StudentServiceImplV2 extends StudentServiceImplV1 {

	protected PrintStream outPut;

	public StudentServiceImplV2() {
		String studentFile = "src/com/biz/grade/exec/data/student.txt";

		try {
			outPut = new PrintStream(studentFile);
		} catch (FileNotFoundException e) {

			System.out.println(studentFile + " 파일을 만들수 없음!!");
			return;
		}
	}

	public void studentList() {
		System.out.println("파일저장중");
		for (StudentVO sVO : studentList) {
			outPut.print(sVO.getNum() + ":");
			outPut.print(sVO.getName() + ":");
			outPut.print(sVO.getDepartment()+":");
			outPut.print(sVO.getGrade() + ":");
			outPut.print(sVO.getTel()+"\n");
		
		}
		outPut.close();
		System.out.println("저장완료");
	}

}
