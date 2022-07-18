package login;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class LoginClient {

	public static void main(String[] args) throws Exception {
		//tcp 로그인 서버 - 10000 포트 설정예정
		//내컴퓨터의시가상ip
		Socket s = new Socket("127.0.0.1", 10000);
		System.out.println("==서버와 연결되었습니다.");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("아이디 ");
		String id = keyboard.nextLine();//아이디에 공백 허용
		System.out.println("암호 ");
		String pw = keyboard.next();//암호 공백 허용x
		
		//키보드입 문자열.getBytes()
		OutputStream o = s.getOutputStream();
		o.write( (id+","+pw+"\n").getBytes() );// 
		//o.close();
		
		//로그인결과 확인
		Scanner input = new Scanner(s.getInputStream());
		String fromServer = input.nextLine();
		System.out.println("로그인 결과===> " + fromServer);
		
		s.close();
		System.out.println("==서버와 연결해제되었습니다.");		
	}

}
