package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest3 {

	public static void main(String[] args) {
		Connection con = null;
		try {
		//0. 설치한 mysql driver 호출
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 호출 완료");
		//1. db연결
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/empdb", 
				"emp2", "emp2");//emp2 계정은 모든 db 사용 권한
		System.out.println("연결 성공");
		
		// employees 테이블에서 급여 총합 조회
		String query = "select avg(salary) from employees where salary >= 25000";//1개행 1개컬럼 리턴
		Statement st = con.createStatement(); //(현재는 비어있는) sql저장 가능한 객체 생성
		ResultSet rs = st.executeQuery(query);// rs 닫혀있다
		System.out.println(rs.next()) ;//1번레코드이동
		System.out.println(rs.getInt("avg(salary)"));
		
		
		rs.close();

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
