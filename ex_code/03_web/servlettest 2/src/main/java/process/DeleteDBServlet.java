package process;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

@WebServlet("/delete")
public class DeleteDBServlet extends HttpServlet {
//delete?id=xxxx&pw=xxxxx
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");	
		MemberDAO dao = new MemberDAO();
		int rows = dao.deleteMember(id, pw);  //1 이상 (id 중복 상태 - 여러개)
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		if(rows >= 1) {
			o.print("<h1>탈퇴처리되셨습니다</h1>");
		}
	}

}
