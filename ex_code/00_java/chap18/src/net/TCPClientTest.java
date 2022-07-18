package net;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientTest {

	public static void main(String[] args) {
		try {
		//3. 서버로 접속 
		Socket s = new Socket("172.30.1.5", 10000);
		System.out.println
		("==" + s.getInetAddress().getHostAddress() + " 서버와 연결되었습니다.");
		//5. 회원가입 , 로그인, 쇼핑, 게시판 요청 전달

		//클라이언트가 서버로 출력
		String id = "안녕 하세요\n";//한글 5개이면 byte 길이 10.  영문 5개이면 byte 배열 길이 5.
		byte id_byte [] = id.getBytes();
		
		OutputStream os = s.getOutputStream();
		os.write(id_byte);
		System.out.println("=== "+ id_byte.length +" ===");
		System.out.println("=== 서버로 아이디 전송했습니다.===");

		//서버로부터 입력(import, 예외처리...)
		InputStream is = s.getInputStream();
		Scanner sc = new Scanner(is);
		String server_reply = sc.nextLine();
		System.out.println("=== 서버로부터 " + server_reply + " 응답을 받았습니다.===");

		
		//7. 서버 접속 해제
		s.close();
		System.out.println
		("==" + s.getInetAddress().getHostAddress() + " 서버와 연결해제되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
