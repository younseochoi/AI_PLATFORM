package mysqljd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class SelectTest5 {

	public static void main(String[] args) {
		Connection con = null;
		try {
			//0. 설치한 mysql driver 호출
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 호출");
			//1. db 연결
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","emp2","emp2");
			System.out.println("연결 성공");
			// 사원이름 부서이름 도시이름 조회 - 런던지역 
			
			//String query = "desc departments";
//			String query = "select e.first_name ,d.department_name ,l.city from employees e"
//					+ " inner join departments d on e.department_id = d.department_id inner join locations l on"
//					+ " d.location_id= l.location_id" ;
			
//			String query = "select e.first_name ,d.department_name ,l.city from employees e"
//					+ " inner join departments d on e.department_id = d.department_id inner join locations l on"
//					+ " d.location_id= l.location_id where l.city = 'london'" ;
			
			String query = "select e.first_name ,ifnull(d.department_name,'부서없음') ,ifnull(l.city,'이사중') from employees e"
					+ " left outer join departments d on e.department_id = d.department_id left outer join locations l on"
					+ " d.location_id= l.location_id" ;
			Statement st = con.createStatement(); //현재 비어있는 sql 저장 가능한 객체 생성 
			ResultSet rs = st.executeQuery(query); //rs 닫혀있다.
			
			//rs.next(); //첫 번째 데이터로 이동 
			
			
			//show tables;
			//show databases;
			//desc 테이블명 ;
			int count = 0; 
			while(rs.next()) { //열어주고 1번 레코드 이동 - t/f 리턴 
				
				count++;
				System.out.println("------------------------------------------------------------------------------------------");
				String arg1 = rs.getString(1);	//컬럼이름 잘 모르니까..
				String arg2 = rs.getString(2);
				String arg3 = rs.getString(3);
				//System.out.println(arg1);
				System.out.println(arg1+" :: "+arg2+" :: "+arg3);
				
			}
			System.out.println("총 레코드 갯수 = "+count);
			rs.close();
			
			Statement st2 = con.createStatement(); //현재 비어있는 sql 저장 가능한 객체 생성 
			ResultSet rs2 = st.executeQuery("select count(*) from employees"); //rs 닫혀있다.
			rs2.next();
			System.out.println("총 사원 수 = "+rs2.getInt(1));
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
