package process;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8080/servlettest/register?id=xxxx
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 요청 받아오자
		//HttpServletRequest - http요청정보객체 , 
		// <form action="/register">
		// <input type=text name="id" >
		// <input type=submit value="" >
		String name = request.getParameter("name");
		String subject[] = request.getParameterValues("subject");//<select multiple, <inout type=checkbox
		if(name == null || name.equals("") ) { 
			name = "입력되지 않은 사용자 "; 
		}
		if(subject == null || subject.length == 0) { 
		   subject[0] = "선택하지 않으셨습니다 "; 
		}
		// 처리 결과- 자바 구현-파일 입출력 , jdbc 
		
		//HttpServletResponse - http응답가능객체
		// 결과 응답= 서버 출력(클라이언트 입력)
		// 브라우저 인코딩 - 서블릿 인코딩
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		System.out.println();
		out.println("<h1> " + name + " 회원님 ");
		//반복문
		for(int i = 0; i < subject.length; i++) {
			out.println( subject[i] + " ");
		}
		out.println(" 과정을 선택하셨습니다 </h1>"); //입력하신 id는 xxxx 입니다 
	}

}
// xxx 회원님 xxxx 과정을 선택하셨습니다


