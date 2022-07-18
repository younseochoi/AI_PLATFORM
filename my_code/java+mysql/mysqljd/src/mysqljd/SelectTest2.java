package mysqljd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class SelectTest2 {

	public static void main(String[] args) {
		Connection con = null;
		try {
			//0. 설치한 mysql driver 호출
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 호출");
			//1. db 연결
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","emp2","emp2");
			System.out.println("연결 성공");
			//employees 에서 사번, 이름, 급여, 입사일, 조회하되 사번이 100번대 (100~199)
			String query = "select employee_id, first_name, salary, hire_date from employees where employee_id between 100 and 199 ;";
			
			Statement st = con.createStatement(); //현재 비어있는 sql 저장 가능한 객체 생성 
			ResultSet rs = st.executeQuery(query); //rs 닫혀있다.
			while(rs.next()) { //열어주고 1번 레코드 이동 - t/f 리턴 
				// 1번컬럼 ~6번컬럼 (각 데이터 타입별 - 해당타입 / 스트링 )
				System.out.println("------------------------------------------------------------------------------------------");
				String id = rs.getString("employee_id");	
				
				String name = rs.getNString("first_name");
				String salary = rs.getString("salary");
				Date hire_date = rs.getDate("hire_date");
				
				System.out.println(id+" "+name+" "+salary+" "+hire_date);
				
			}
			rs.close();
		}catch(ClassNotFoundException e) {
			System.out.println("미설치이거나 classpath 미등록 또는 드라이버명 오타확인 ");
		}catch(SQLException e) {
			System.out.println("db연결 정보 잘못확인 ");
			e.printStackTrace();
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
