package mysqljd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class SelectTest6 {

	public static void main(String[] args) {
		Connection con = null;
		try {
			//0. 설치한 mysql driver 호출
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 호출");
			//1. db 연결
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","emp2","emp2");
			System.out.println("연결 성공");

			
			
			//subquery
			/* create table a(select*from member);
			 * insert into b (select*from member);
			 * update c set name = '이름변경' where id = (select id from member where name = '홍길동')
			 * select (select ...)*/
			
			/*문제 : William 사원보다 급여를 더 많이 받는 사원의 사번, 이름, 급여 조회했을 때 
			여러명의 William 조회되면 모든 William 보다 급여를 많이 받는 사원 조회 작은거 이상 - any 
			윌리엄중 큰 급여보다커야한다 -all , 윌리엄중 작은 급여보다 커야한다 - any
			*/
			
			// 윌리엄 두사람나와서 두사람중 하나의 급여중에 아무거나 크면됨 
			//String query = "select employee_id, first_name, salary from employees where salary > all (select salary from employees where first_name='William')";
			
			//윌리엄과 똑같은 급여를 받는 사람 7400, 8300 급여받는 사람 가져와! -> in 사용 -> =any 랑 똑같음 
			String query = "select employee_id, first_name, salary from employees where salary in (select salary from employees where first_name='William')";
			
			Statement st = con.createStatement(); //현재 비어있는 sql 저장 가능한 객체 생성 
			ResultSet rs = st.executeQuery(query); //rs 닫혀있다.
			
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
