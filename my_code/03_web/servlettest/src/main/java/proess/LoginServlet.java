package proess;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String role = request.getParameter("role");
		
		//admin / user
		String output = "";
		if(role.equals("admin")) {
			output = id+"계정의 관리자님, 로그인하셨습니다.";
			output += "<ul>"
					+ "<li>모든 사용자 정보 조회</li>"
					+ "<li>블랙리스트 관리</li>"
					+ "<li>상품관리</li>"
					+ "</ul>";
		}else if(role.equals("user")) {
			output = id+"계정의 사용자님, 로그인하셨습니다.";
			output += "<ul>"
					+ "<li>내 정보 조회</li>"
					+ "<li>로그아웃</li>"
					+ "<li>게시판 보기</li>"
					+ "</ul>";
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter o = response.getWriter();
		o.print(output);
		
	}

}
