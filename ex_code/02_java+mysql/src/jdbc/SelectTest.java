package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

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
		
		String query = "select id, "
				+ "insert(password, 1, length(password), repeat('*', length(password))) 암호, "
				+ "name, phone, email, "
				+" date_format(regdate, '%y/%m/%d %h시%i분%s초') 가입일 from member";
		Statement st = con.createStatement(); //(현재는 비어있는) sql저장 가능한 객체 생성
		ResultSet rs = st.executeQuery(query);// rs 닫혀있다
		while(rs.next()) {// 열어주고 1번레코드 이동- t/f 리턴
			//1번컬럼 ~ 6번컬럼(각 데이터타입별 - 해당타입 / 모두 문자열로) 
			System.out.println
			(rs.getString(1) + " : " + " : " + rs.getString("암호") + " : " 
			+ rs.getString("name") +" : "
			 + rs.getString("phone") + ":" + rs.getString("email") + ":"
			 + rs.getString("가입일")		); 


		}
		
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
