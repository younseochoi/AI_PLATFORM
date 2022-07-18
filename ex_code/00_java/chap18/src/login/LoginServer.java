package login;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
//ctrl_shift_o
public class LoginServer {

	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(10000);
		System.out.println("==서버 시작");
		while(true) {
		Socket s = ss.accept();
		System.out.println("==클라이언의 접속 허용");
		
		Scanner input = new Scanner(s.getInputStream());
		String fromClient = input.nextLine();
		System.out.println(fromClient); //id(공백),암호
		String[] id_pw = fromClient.split(",");
		String id = id_pw[0];
		String pw = id_pw[1];
		
		HashMap<String, String> users = new HashMap<String, String>();
		users.put("multi", "campus"); //key –아이디 value-암호
		users.put("java", "program");
		users.put("oracle", "db");
		
		Set<String> ids = users.keySet();
		boolean exists = false;
		String toClient = "";
		for(String i : ids) {
			if(id.equals(i)) {//아이디 존재
				exists = true;
				String v = users.get(i);//해당 아이디의 암호 얻어온다
				if(pw.equals(v)) {// 암호 확인
					toClient = "정상 로그인 사용자입니다.\n";
				}
				else {// 해당 아이디 존재. 암호 다르다
					toClient = "암호를 확인하세요.\n";
				}
			}//outer if end
		}//for 
		
		if(exists == false) {
			toClient = "회원 가입부터 하세요.\n";
		}
		
		OutputStream o = s.getOutputStream();
		o.write(toClient.getBytes());
		o.close();
		
		s.close();
		System.out.println("==클라이언의 접속 해제");
		if(id.equals("quit") &&	pw.equals("quit")) {
			System.out.println("==서버 종료");
			ss.close();
		}
		
		
		}
	}

}
