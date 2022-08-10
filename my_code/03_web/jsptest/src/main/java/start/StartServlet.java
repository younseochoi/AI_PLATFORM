package start;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/start")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String menu = request.getParameter("menu");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		RequestDispatcher rd =null;
		if(menu =="" || menu==null) {
			out.println("<h1>메뉴입력하세요.</h1>");
		}else if(menu.equals("memberlist")) {
			MemberDAO dao = new MemberDAO();
			rd = request.getRequestDispatcher("allmemberlist.jsp");
			
		}else if(menu.equals("boardwriting")) {
			rd = request.getRequestDispatcher("boardwrite.jsp");
		}else {
			out.println("<h1>아직 준비되지 않은 메뉴입니다.</h1>");
			out.println("<a href='allmemberlist.jsp'>가입 회원 명단 보기</a><br>");
			out.println("<a href='boardwrite.jsp'>게시글 등록</a>");
		}
		
		rd.forward(request,response);
	}



}
