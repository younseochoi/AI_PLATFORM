package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
		//0. 설치한 mysql driver 호출
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 호출 완료");
		//1. db연결
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", 
				"emp2", "emp2");//emp2 계정은 모든 db 사용 권한
		System.out.println("연결 성공");
		// member 테이블에서 회원정보 수정 
		// 아이디입력 - 이름 폰번호 이메일만 수정 
		//키보드입력변수(id1 - 4명 모두 이름, 폰, 이메일 입력 변경)
		//이강산 , 010-4321-4321 , lee@tech.com
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디는 : "); 
		String id = sc.next(); 
		System.out.print("수정할 이름은 : ");
		String name = sc.next();
		System.out.print("수정할 폰번호는 : ");
		String phone = sc.next();
		System.out.print("수정할 이메일은 : ");// @
		String email = sc.next();
		
		String query = "update c_member "
				+ " set NAME=?, PHONE=? , EMAIL=?"
				+ "	WHERE ID=?";
		
		//String duery = "delete fpr from 테이블병 where oid=?"
		
		PreparedStatement pt = con.prepareStatement(query);
		pt.setString(1,name);
		pt.setString(2, phone);
		pt.setString(3, email);
		pt.setString(4, id);
		int rows = pt.executeUpdate();
		
		
		}catch(ClassNotFoundException e) {
			System.out.println("미설치이거나 classpath 미등록 또는 드라이버명 오타 확인");
		}catch(SQLException e) {
			System.out.println("db연결 정보 잘못 확인");
			e.printStackTrace();
		}finally {
			//4. db연결해제
			try {
			con.close() ;// mysql 외부 연결 허용 최대치 - 100여개
			System.out.println("연결 해제 성공");
			}catch(SQLException e) { }
		}

	}

}
