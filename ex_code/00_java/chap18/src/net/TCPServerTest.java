package net;

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
			//6. 클라이언트 요청 분석-적당 응답 전달
			
			// 서버가 클라이언트로부터 데이터를 입력 방법2
			InputStream is = s.getInputStream();
			//DataInputStream ds = new DataInputStream(is);
			//String id = ds.readLine();
			Scanner sc = new Scanner(is);
			String id = sc.nextLine();
			System.out.println("===클라이언트가 전달한  아이디는 " + id + "  입니다.");			

			//클라이언트로 응답 인사 전달 = 서버가 클라이언트로 출력
			OutputStream os = s.getOutputStream();
			String server_reply = " 잘 지냅니다.\n";
			byte[] server_reply_byte = server_reply.getBytes();
			os.write(server_reply_byte);
			System.out.println("===클라이언트 로 응답했습니다===");
	
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
