package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest7 {

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

	    /*
	     * 키보드로 입력 
	     * 제외할 월 : 01-12 사이 값 입력(03)
	     * ==> 입사월별 급여 총합 구하되 위에서 입력 월은 제외.
	     * 
	     *  입사월 급여 총합
	     *   01    xxx
	     *   02    xxx
	     *   04    xxxx
	     *   ......
	     *   12    xxx
	     *  
	     *  employees 테이블 급여-salary, 입사월포함컬럼-hire-date
	     *  
	     * */
		Scanner scan = new Scanner(System.in);
		System.out.println("제외할 월 : ");
		String month = scan.next();
		String sql=
				"select substr(hire_date, 6, 2) 입사월 , sum(salary) '급여 총합' "
				+ " from employees "
				+ " where date_format(hire_date, '%m') != " + month 
				+ " group by month(hire_date)"
				+ " order by 입사월";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString("입사월") + " : " + rs.getInt("급여 총합"));
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
