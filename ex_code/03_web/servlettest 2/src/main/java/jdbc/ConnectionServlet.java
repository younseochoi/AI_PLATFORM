package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/connection")
public class ConnectionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			long start = System.currentTimeMillis();

			for(int i = 1; i <=10000; i++){
				Connection conn = DriverManager.getConnection
						("jdbc:mysql://127.0.0.1:3306/memberdb", "emp3", "emp3");
				System.out.println(i + " 번째 mysql 연결 성공");
				conn.close();
			}
			
			//DataSource = connection pooling 클래스 톰캣 제공 사용
			//1.context.xml 파일 정의 내용 읽어올 준비
			Context initContext = new InitialContext();
			
			//2. <Resource 이름 태그들  설정 읽어와
			Context envContext = (Context)initContext.lookup("java:/comp/env");// java - component - environment파일
			
			//3. jdbc/mydb 설정 태그만 읽어와서 connection pooling 클래스 객체 생성
			DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
			// tomcat 시작 미리 생성 - 배열 형태 관리- 반납- 빌려주고 반복
			/*long start = System.currentTimeMillis();
			for(int i = 1; i <=10000; i++){
				Connection conn= ds.getConnection(); //미리 생성 con 빌려온다
				System.out.println(i + " 번째 mysql 연결 성공");
				conn.close();// con 반납한다
			}*/
			
			long stop = System.currentTimeMillis();
			System.out.println( (stop - start) + " (1/1000초) 소요 " );
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
