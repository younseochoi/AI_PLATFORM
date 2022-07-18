package mysqljd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
			//0. 설치한 mysql driver 호출
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 호출");
			//1. db 연결
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/memberdb","emp2","emp2");
			System.out.println("연결 성공");
			// member 테이블에 회원가입 정보저장
			//id_jdbc , 1234 , '김회원' , '010-1234-4321' , 'kim.@mem.net', 현재시각 
			// 2-1. sql 작성 - 전송 
//			String query = "insert into member values('id_jdbc1' "
//					+ ",1234, '김회원', '010-1234-1234' , 'kim@mem.net', now())";
//			String query = "insert into member values('id_jdbc1' ,1234, '김회원', '010-1234-1234' , 'kim@mem.net', now())";
			
			
			
			//키보드 입력받아 db 저장 
			Scanner sc = new Scanner(System.in);
//			System.out.print("아이디는 : ");
//			String id = sc.next();
//			
//			System.out.print("암호는 : ");
//			String pw = sc.next();
//			
//			System.out.print("이름은 : ");
//			String name = sc.next();
//			
//			System.out.print("폰번호는 : ");
//			String phone = sc.next();
//			
//			System.out.print("이메일은 : ");
//			String email = sc.next();
			
//			String query = "insert into c_member values ('"
//					+ id + "',"+pw+",'"+ name+"','"  +phone +"','"+email +"',now())";
			
			System.out.print("제목 : ");
			String title = sc.nextLine();
			
			System.out.print("내용 : ");
			String contents = sc.nextLine();
			
			System.out.print("작성자 : ");
			String name = sc.next();
			
//			
			String query = "insert into c_memo (title,contents,time, writer) values ('"
					+ title + "','"+contents+"', default,'" +name +")";
			
			//String query = "insert into c_memo (title,contents,time, writer) values ('"+ title + "','"+contents+"', default,'" +name+")";
			
			//2-2. sql 저장 - 전송  
			Statement st = con.createStatement();
//			int rowcount = st.executeUpdate(query);
			int rowcount = st.executeUpdate
					//("create table test(a int, v varchar(10))");
					//("insert into test values(1,'java')");
					("delete from test where a = 1"); //조건 맞는 데이터 = 레코드 삭제 (테이블 구조 남는다)
					//("drop table test"); // 레코드와 테이블도 삭제 
			
			System.out.println("저장행의 갯수 = "+rowcount);
			
		}catch(ClassNotFoundException e) {
			System.out.println("미설치이거나 classpath 미등록 또는 드라이버명 오타확인 ");
		}catch(SQLException e) {
			System.out.println("db연결 정보 잘못확인 ");
		}finally {
			try {
				//4 연결해제 
				con.close(); // mysql 연결 허용 최대치 - 100여개
				System.out.println("연결해제 성공"); 
			}catch(SQLException e) {
				
			}
		}
	}

}
