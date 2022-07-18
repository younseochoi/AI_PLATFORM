package chap18;

import java.io.FileReader;
import java.io.IOException;

public class FileInputTest {

	public static void main(String[] args) {
		//FileInputStream fi = null;
		FileReader fi = null;
		try {
			//파일 입력 - 파일 존재x 예외발생
		// fi = new FileInputStream("src/chap18/b.java");
		fi = new FileReader("src/chap18/FileCopyTest.java");
		// os에게 파일 사용 접근 허락 요청 - os 수락
		while(true) {
			int result = fi.read(); //--->예외발생 
			System.out.print((char)result);
			if(result == -1) { break; }
		}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fi.close();// os에게 반납
			}catch(IOException e) {}
			
		}
	}

}