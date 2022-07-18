package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectionTest {

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
		// c_member, member, c_memo 3개 테이블 조회
		// member 테이블에 회원 가입 정보 저장- 키보드 입력
		// id_jdbc1 , 1234, 김회원, 010-1234-1234 , kim@mem.net 현재시각
        // 2-1. sql 작성 
		/*String query = "insert into member"
				+ " values( 'id_jdbc1' "
				+ " , 1234, '김회원', '010-1234-1234' , 'kim@mem.net' ,  now())";*/
		//키보드입력변수
		/*Scanner sc = new Scanner(System.in);
		System.out.print("아이디는 : ");
		String id = sc.next(); //
		System.out.print("암호는 : ");
		String pw = sc.next();
		System.out.print("이름은 : ");
		String name = sc.next();
		System.out.print("폰번호는 : ");
		String phone = sc.next();
		System.out.print("이메일은 : ");
		String email = sc.next();
		
		String query = "insert into c_member"
		+ " values( '" + id + "' , " + pw + ", '" + name + "','" + phone + "','" + email+ "',  now())";
	*/
		
	/*	Scanner sc = new Scanner(System.in);
		System.out.println("제목 : ");
		String title = sc.nextLine(); 
		
		System.out.println("내용 : ");
		String contents = sc.nextLine();
		
		System.out.print("작성자 : ");
		String writer = sc.next();

		String query = 
		"insert into c_memo(title, contents, time, writer) values"
		+ " ('" + title + "', '" + contents + "', default, '" + writer + "')";
		*/
		
		//여러개행 insert 결과 리턴
		String query = "insert into member (select * from c_member)";
		
		// 이론적 create table 실행 가능. workbench에서만 수행할 것을 권고
		// 보안적 db 자체에서만 테이블 생성 + jdbc 프로그램 insert / delete / update / select
		//2-2 sql 저장-전송
		Statement st = con.createStatement();
		int rowcount = st.executeUpdate(query);//rowcount = 1개이상
		System.out.println("저장 행의 갯수=" + rowcount);
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
