package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
		//0. 설치한 mysql driver 호출
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 호출 완료");
		//1. db연결
		/*Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/empdb", 
				"emp", "emp"); //emp 계정은 empdb만 사용 권한 
		*/
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", 
				"emp2", "emp2");//emp2 계정은 모든 db 사용 권한
		/*Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", 
				"root", "1234");//root계정은 사용사 생성 + 모든 db 사용 권한
		*/
		System.out.println("연결 성공");
		// c_member, member, c_memo 3개 테이블 조회
		
		
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
