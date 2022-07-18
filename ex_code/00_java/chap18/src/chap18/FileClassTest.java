package chap18;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FileClassTest {

	public static void main(String[] args) throws IOException {//개발자 개입하지 않고 자바 내장 처리
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		//name 을 File 객체로 생성
		File f = new File(name);//   c:~/src/chap18/FileClassTest.java
		if(f.exists()) {
			System.out.println("존재합니다");
			if(f.isFile()) {//파일
				//크기 경로 읽기 쓰기 마지막수정
				System.out.println("파일크기(byte단위)=" + f.length());
				System.out.println("전체경로=" + f.getCanonicalPath());
				System.out.println("파일읽기여부=" + f.canRead());
				System.out.println("파일쓰기여부=" + f.canWrite());	
				long time = f.lastModified();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E, a hh:mm:ss");
				String timeString = sdf.format(time);
				//2022‎년 ‎7‎월 ‎8‎일 ‎금요일, ‏‎오후 1:17:53
				System.out.println("최종수정시각=" + timeString);
			}
			else {//디렉토리
				String [] details = f.list();
				System.out.println("==========================");
				for(String d : details) {
					System.out.println(d);
				}
				System.out.println("==========================");
			}// inner else
		}//outer if end
			
		else {
			System.out.println(name + " 이름의 파일이나 디렉토리는 없습니다");
			// a.txt파일(0byte) /디렉토리(리스트x) 생성해라
			System.out.println(f.createNewFile());
		}
	}

}
