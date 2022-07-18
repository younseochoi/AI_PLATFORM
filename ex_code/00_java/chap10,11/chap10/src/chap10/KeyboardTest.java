package chap10;

import java.io.IOException;

public class KeyboardTest {

	public static void main(String[] args) {
		try {
			while(true) {
			//a-97  A-65 0-48 ㄱ-234 엔터키-13
			//영문, 숫자, 키보드특수문자들 여러개 o . 
			//한글 완성값 x, 정수 실수 입력x
			int result = System.in.read();
			
			//if(result == 13) { break ; } 
			if(result == '\n') { break ; } 
			
		    System.out.println((char)result);
			}
			
		}catch(IOException e) {
			//키보드x, 결함
			e.printStackTrace();
		}

	}

}
