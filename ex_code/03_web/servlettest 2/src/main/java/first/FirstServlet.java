package first;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8080/servlettest/f
//  first.FirstServlet 실행 url 별명 - " f "
@WebServlet("/f")
public class FirstServlet extends HttpServlet {
	 	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	 			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	 	
	 	response.getWriter().println("<h1>title</h1>");
	}

}
// 1.자바 서블릿 클래스 정의규칙 - 

// 2 새로 컴파일 (이클립스 자동) - tomcat 재시작 (이클립스 자동)
// 3. 실행-run as - run on server - 서버 자바 문장 실행 결과 - 브라우저 실행 결과 - url 
// servlet = server side applet (applet  - 자바 클라이언트 실행 프로그램 종류)