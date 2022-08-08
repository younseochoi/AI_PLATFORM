package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mypage")
public class mypage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); //브라우저 2번째  요청 - 해당 클라이언트 세션 id 검사  
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(session.getAttribute("sessionid") != null) {
			String sessionid= (String) session.getAttribute("sessionid");
			// MemberDTO 객체 생성 
			out.print("<h1>본인 정보 확인 가능합니다."+sessionid+"</h1>");
			
		}else {
			out.print("<h1>로그인 먼저 하셔야 본인 정보 확인이 가능합니다. </h1>");
		}
	
	}

}
