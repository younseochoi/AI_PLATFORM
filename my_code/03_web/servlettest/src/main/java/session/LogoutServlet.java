package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션 객체 리턴
		HttpSession session =  request.getSession();
		String sessionid = "";
		if(session.getAttribute("sessionid") != null) {
		
			 sessionid= (String) session.getAttribute("sessionid");
			 //세션 어트리뷰트를 없애라.
			 session.removeAttribute("sessionid");
			
		}else {
			sessionid ="손님";
		}
		
//		session.invalidate();
//		session.setMaxInactiveInterval(0);
	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.print("<h1>"+sessionid+"회원님, 로그아웃 성공</h1>");
	}

}
