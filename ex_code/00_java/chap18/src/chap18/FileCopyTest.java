package chap18;

import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
//출력시에 각 라인앞에 라인번호 출력 1라인 : xxxx
public class FileCopyTest {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		String inputfile = "src/chap18/FileClassTest.java";
		String outputfile = "c.txt";
		/* 1. 입력파일 존재 x - 예외 발생 
		 * 2. 입력파일 존재 o,  출력파일 존재 x - 출력파일 empty 파일 생성 출력
		 * 3.  입력파일 존재 o,  출력파일 존재 o - 기본 실행 출력 파일 기존 저장 내용 삭제 후 출력
		 * 4.  입력파일 존재 o,  출력파일 존재 o - 기본 실행 출력 파일 기존 저장 내용 유지 추가 출력
		 * */
		try {
		fr = new FileReader(inputfile);
		fw = new FileWriter(outputfile, true);
		//1라인 : 출력
		int linenum = 1;
		String linestr = linenum + "라인 : ";
		fw.write(linestr);
		while(true) {
			int result = fr.read();
			if(result == -1) {break;}
			fw.write(result);// 파일 내용 출력 \n 이 나오면 2라인 : 출력 포함
			if(result == '\n') {
				fw.write(++linenum + "라인 : ");
			}
			
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
