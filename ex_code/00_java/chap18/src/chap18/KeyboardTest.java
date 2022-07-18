package chap18;

import java.io.IOException;

public class KeyboardTest {

	public static void main(String[] args) {
		try {
		while(true) {
		//System.out.println("99. 예금조회");
		int result = System.in.read(); //키 1개 입력한 내용의 unicode 해당 숫자 리턴
		System.out.println( result + ":" + (char)result);
		
		//if( result == (int자동)'\n')
		if(result == 13) { break;}
		}//while end
		}//try
		catch(IOException 	e) {
			e.printStackTrace();
		}
	}

}
// 자바 데이터타입 입력  , 한글 변환 기능 없다 

