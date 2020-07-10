package com.biz.grade.exec;

import com.biz.grade.service.ScoreService;
import com.biz.grade.service.ScoreServiceImplV1;

public class ScoreEx_01 {
	
	public static void main(String[] args) {
		
		ScoreService sService = new ScoreServiceImplV1();
		
		
		sService.inputScore();
		sService.scoreList();
		sService.calcSum();
		sService.calcAvg();
		
		
		
		
	}

}
