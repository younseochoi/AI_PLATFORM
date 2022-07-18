package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest6 {

	/**
	 * @param args
	 */
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

		// subquery
		
		/* create table a select * from member --> 테이블 생성+데이터레코드 복사
		 * insert into b (select * from member ) --> 데이터레코드 복사
		 * update c set name='이름변경' where id= (select id from member where name='홍길동')
		 * select (select...)
		 * 
		 *   William 사원보다 급여를 더 많이 받이 사원의 사번, 이름, 급여 조회하되 
		 *  여러명의 william이 조회되면 모든 william들보다 급여를 많이 받는 사원 조회
		 * 
		 * select employee_id, first_name, salary
		 * from employees
		 * where salary > (select salary from employees where first_name='william')
		 *  > all (subquery 레코드 모두보다 커야 한다)
		 *  > any (subquery 레코드중 1개보다만 크면 된다)
		 *  = any : in (subquery 레코드중 1개와 같다)
		 *  7400 나 8300 급여
		 *  
		 * */
		String query = "select employee_id, first_name, salary"
				+ " from employees"
				+ "	where salary in (select salary from employees where first_name='william')";//여러개행 db명 1개컬럼 리턴
		Statement st = con.createStatement(); //(현재는 비어있는) sql저장 가능한 객체 생성
		ResultSet rs = st.executeQuery(query);// rs 닫혀있다
		
		int count = 0;
		while(rs.next()) {//1번레코드이동
			count++;
			System.out.println(rs.getInt(1)+ "-" + rs.getString(2) + "-" + rs.getDouble(3));
		}
		
		System.out.println("=== 총 레코드갯수 - " + count);
		rs.close();
		Statement st2 = con.createStatement();
		ResultSet rs2 = st2.executeQuery("select count(*) from employees");
		rs2.next();
		System.out.println("=== 총 사원갯수 - " + rs2.getInt("count(*)"));
		
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
