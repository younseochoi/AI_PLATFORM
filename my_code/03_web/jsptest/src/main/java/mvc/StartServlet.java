package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/starting")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Menu 파라미터값 분석
		String menu = request.getParameter("menu");
		String jspfile ="";
		if(menu.equals("memberlist")) {
			
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberDTO> list = dao.selectAllMember();
			request.setAttribute("memberlist", list);
			jspfile = "/mvc/allmemberlist.jsp";
		}else if(menu.equals("boardwriting")) {
			String id = "";
			if(request.getParameter("id") == null) {
				id="guest";
			}
			else {
				id = request.getParameter("id");
			}
			HttpSession session = request.getSession();
			session.setAttribute("session_id", id);
			jspfile = "/mvc/boardwrite.jsp";
		}else {
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(jspfile);
		rd.forward(request, response);
	}

}
