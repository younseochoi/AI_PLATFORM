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
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");			
//			long start = System.currentTimeMillis();
//
////			for(int i =0;i<1000;i++) {
////				
////				Connection conn = DriverManager.getConnection
////						("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");
////				System.out.println(i+"번째 mysql 연결 성공");
////				conn.close();
////			}
			
			
			// 1. context.xml 파일 정의 내용 읽어올 준비 
			Context initContext = new InitialContext();
			
			//2. <Resourse 이름 설정 태그 읽어와 - 항상 고정 
			Context envContext = (Context) initContext.lookup("java:/comp/env") ; //java - component -  environment
			
			//3. jdbc/mydb 설정 태그만 읽어와 connection pooling 클래스 객체 생성 
			// tomcat 시작 미리 생성 - 배열 형태 관리 반납 - 빌려주고 반납 
			DataSource ds = (DataSource) envContext.lookup("jdbc/mydb");
			long start = System.currentTimeMillis();

			for(int i =0;i<1000;i++) {
				Connection conn = ds.getConnection(); //미리 생성된 커넥션 빌려오기 
				System.out.println(i+"번째 mysql 연결 성공");
				conn.close(); //커넥션 반납 
			}
			long stop = System.currentTimeMillis();
			System.out.println((stop-start)+"(1/1000)초 소요");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		//DataSource connection pooling 클래스톰캣 사용 
	
	}

}
