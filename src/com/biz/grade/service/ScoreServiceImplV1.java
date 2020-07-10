package com.biz.grade.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.biz.grade.config.SplitPos;
import com.biz.grade.vo.ScoreVO;

public class ScoreServiceImplV1 implements ScoreService {

	private List<ScoreVO> scoreList;
	private FileReader fileReader;
	private BufferedReader buffer;

	public ScoreServiceImplV1() {
		scoreList = new ArrayList<ScoreVO>();

	}

	public boolean inputScore() {

		String scoreFile = "src/com/biz/grade/exec/data/score.txt";
		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {

			fileReader = new FileReader(scoreFile);
			buffer = new BufferedReader(fileReader);
			String reader = "";
			while (true) {
				reader = buffer.readLine(); // buffer로 부터 파일에서 한줄씩 읽기
				if (reader == null) { // 파일 끝에 도달했으면!!
					break; // 파일 읽기를 그만 멈추어라
				}

				String[] scores = reader.split(":");
				ScoreVO sVO = new ScoreVO();
				sVO.setNum(scores[SplitPos.SCORE.SC_NUM]);
				sVO.setKor(Integer.valueOf(scores[SplitPos.SCORE.SC_KOR]));
				sVO.setEng(Integer.valueOf(scores[SplitPos.SCORE.SC_ENG]));
				sVO.setMath(Integer.valueOf(scores[SplitPos.SCORE.SC_MATH]));
				sVO.setMusic(Integer.valueOf(scores[SplitPos.SCORE.SC_MUSIC]));
				scoreList.add(sVO);

			}
			buffer.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println(scoreFile + "파일을 읽기위해 open 하는 중 오류 발생");
			return true;
		} catch (NumberFormatException e) {
			System.out.println("점수를 숫자로 바꾸는 과정에서 오류 발생");
		} catch (IOException e) {
			System.out.println("버퍼로 부터 데이터를 읽는데 문제가 발생!!");

		} 
		return true;

	}

	
	public void calcSum() {

		for (ScoreVO sVO : scoreList) {
			int sum = sVO.getKor();
			sum += sVO.getEng();
			sum += sVO.getMath();
			sum += sVO.getMusic();
			sVO.setSum(sum);
		}
	}

	
	public void calcAvg() {
		for (ScoreVO sVO : scoreList) {
			float sum = (float) sVO.getSum();
			float avg = sum / 4;
			sVO.setAvg(avg);
		}
	}

	
	public void scoreList() {
		
		for (ScoreVO sVO : scoreList) {

			System.out.print(sVO.getNum() + ":");
			System.out.print(sVO.getKor() + ":");
			System.out.print(sVO.getEng() + ":");
			System.out.print(sVO.getMath() + ":");
			System.out.print(sVO.getMusic()+ ":");
			System.out.print(sVO.getSum() + "\n");
			System.out.printf("%5.2f\n", sVO.getAvg());
			
			int intSum = 0;
			float intAvg = 0;
	

		}
		
		
		
		
		
	}

}
