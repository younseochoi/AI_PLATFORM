package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;


@WebServlet("/session")
public class SessionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//sessiontest1.jsp 저장 세션정보 있으면 읽자
		HttpSession se = request.getSession(); 
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(se.getAttribute("member") != null) {
			MemberDTO member = (MemberDTO)se.getAttribute("member");
			out.println("<h1>세션 정보를 조회합니다</h1>");
			out.println("<table border=3>");
			out.println("<tr><td> 아이디 </td><td>"+ member.getId() + "</td></tr>");
			out.println("<tr><td> 이름 </td><td>" + member.getName()+ "</td></tr>");
			out.println("<tr><td> 폰 </td><td>" + member.getPhone()+ "</td></tr>");
			out.println("<tr><td> 이메일 </td><td>" + member.getEmail()+ "</td></tr>");
			out.println("<tr><td> 가입일 </td><td>" + member.getRegdate()+ "</td></tr>");
			out.println("</table>");
		}
		else {
			out.println("<h1>조회할 정보가 없습니다.</h1>");
		}
	}

}
