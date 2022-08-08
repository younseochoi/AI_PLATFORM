package proess;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자 요청받아오자
		// HttpServletRequest - http 요청 정보 객체 ,
		// <form action = "/register">
		// <input type=text name="id">
		// <input type=submit value="">
		String name = request.getParameter("name");
		String subject[] = request.getParameterValues("subject");
		if(name == null|| name.equals("")) {
			name="입력하지 않은 사용자"; //예외처리 
		}
		if(subject == null||subject.length==0) subject[0]="선택하지 않은 과정"; //예외처리 
		
		//처리 결과 - 자바 구현 
		//	HttpServletResponse  http 응답가능 객체 
		//결과 응답 = 서버 출력(클라이언트 입력)
		
		//브라우저 인코딩 - 서블릿 인코딩 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>"+name+"회원님 , ");
		for(int i = 0 ; i<subject.length;i++) {
		out.print(subject[i]+" "); //입력하신id는ㅇㅇㅇ입니다. 
		}
		out.println("과목을 선택하셨습니다.</h1>");
		//////////////////////////////////////////////////////
		Enumeration<String> names =  request.getParameterNames();
		while(names.hasMoreElements()) {
			out.println(names.nextElement()+"<br>");
		}
		
	}

}
