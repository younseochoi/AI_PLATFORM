package mysqljd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class SelectTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
			//0. 설치한 mysql driver 호출
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 호출");
			//1. db 연결
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/memberdb","emp2","emp2");
			System.out.println("연결 성공");
//			String query = "select id, password,name,email,phone, DATE_FORMAT(legdate,'%y/%m/%d %h시%i분%s초') 가입일 from member";
			String query = "select id, insert(password,1,char_length(password),repeat('*',char_length(password))) 비밀번호 ,name,email,phone, DATE_FORMAT(legdate,'%y/%m/%d %h시%i분%s초') 가입일 from member";
			Statement st = con.createStatement(); //현재 비어있는 sql 저장 가능한 객체 생성 
			ResultSet rs = st.executeQuery(query); //rs 닫혀있다.
			while(rs.next()) { //열어주고 1번 레코드 이동 - t/f 리턴 
				// 1번컬럼 ~6번컬럼 (각 데이터 타입별 - 해당타입 / 스트링 )
				System.out.println("------------------------------------------------------------------------------------------");
				String id = rs.getNString("id");	
				String password = rs.getString("비밀번호");
				//int password = rs.getInt("password");
				String name = rs.getNString("name");
				String phone  = rs.getString("phone");
				String mail = rs.getString("email");
				String date = rs.getString("가입일"); //시분초 다 읽음 
				//Date date = rs.getDate("legdate"); //시분초 빠짐 
				
				System.out.println(id+" "+password+" "+name+" "+phone+" "+mail+" "+date);
				//System.out.println(id+" "+name+" "+phone+" "+mail+" "+date);
			}
			rs.close();
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
