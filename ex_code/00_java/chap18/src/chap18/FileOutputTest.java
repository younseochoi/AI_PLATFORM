package chap18;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputTest {

	public static void main(String[] args) {
		//FileOutputStream fo = null;
		FileWriter fo = null;
		try {
			//출력 파일 존재o - false이거나 매개변수 없거나  - 기존파일 내용 삭제 후 새로운 내용 write
			//출력 파일 존재o - true - 기존파일 내용 유지 - 추가 write
			//출력 파일 존재x - 새 파일 생성
		// fo = new FileOutputStream("src/chap18/b.java", true);
		fo = new FileWriter("src/chap18/b.java", true);	
		 fo.write(66);
		 fo.write(98);
		 fo.write(13);
		 fo.write('B');
		 fo.write('b');
		 fo.write('\n');
		 fo.write('가');
		 fo.write('나');
		 fo.write('\n');		 
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fo.close();// os에게 반납 . os jdk 버전 - b.java 생성 - 출력 x
			}catch(IOException e) {}
			
		}
	}

}
