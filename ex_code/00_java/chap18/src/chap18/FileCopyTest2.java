package chap18;

import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.Scanner;
//출력시에 각 라인앞에 라인번호 출력 1라인 : xxxx
public class FileCopyTest2 {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		String inputfile = "src/chap18/FileClassTest.java";
		String outputfile = "d.txt";
		/* 1. 입력파일 존재 x - 예외 발생 
		 * 2. 입력파일 존재 o,  출력파일 존재 x - 출력파일 empty 파일 생성 출력
		 * 3.  입력파일 존재 o,  출력파일 존재 o - 기본 실행 출력 파일 기존 저장 내용 삭제 후 출력
		 * 4.  입력파일 존재 o,  출력파일 존재 o - 기본 실행 출력 파일 기존 저장 내용 유지 추가 출력
		 * */
		try {
		fr = new FileReader(inputfile);
		fw = new FileWriter(outputfile, true);
		
		Scanner sc = new Scanner(fr);
		int linenum = 1;

		while(sc.hasNextLine()) { //파일현재줄 입력내용 있는지 판단하고 다음줄 이동
			String linestr = linenum++ + " 라인 : ";
			String fileline = sc.nextLine() + "\n"; // 1줄('\n')이전까지 입력( '\n' 제외)
			fw.write(linestr + fileline);
		}
		
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
			fr.close();
			fw.close();
			}catch(IOException e) {}
		}

	}

}
