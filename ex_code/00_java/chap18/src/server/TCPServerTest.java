package server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServerTest {

	public static void main(String[] args) {
		try {
		//1. 서버 시작
		ServerSocket ss = new ServerSocket(10000);
		//이미 TCPServerTest 실행중(아직 종료이전). 10000번 포트 사용 프로그램 실행 불가
		System.out.println("==서버는 10000 번 포트에서 동작중입니다===");
		while(true){
			//2. 클라이언트 접속 대기 . 4. 클라이언트의 접속 허용
			Socket s = ss.accept();
			System.out.println
			("==" + s.getInetAddress().getHostAddress() + " 클라이언트와 연결되었습니다.");
			//6. 클라이언트 요청받음-응답
			//클라이언트 요청받음
			for(int index=1; index <=3; index++) {
			InputStream i = s.getInputStream();
			Scanner si = new Scanner(i);
			int fromClient = si.nextInt();// 엔터, 공백 이전 정수형 입력
			System.out.println(++fromClient);
			//while(si.hasNextLine()) {
			//String fromClient = si.nextLine();
			//System.out.println("==" + fromClient + " 라는 인삿말을 전달받았습니다. ");
			//}
			
			//클라이언트로 응답
			String reply = "네 안녕합니다. 잘 지내시죠\n";
			OutputStream o = s.getOutputStream();
			o.write(reply.getBytes());
			}
			
			//8. 클라이언트 접속 해제
			s.close();
			System.out.println("==" + s.getInetAddress().getHostAddress() + " 클라이언트와 연결해제되었습니다.");
		}//while end
		}catch(Exception e) {
			e.printStackTrace();
		}
		//9. 서버 종료

	}

}
