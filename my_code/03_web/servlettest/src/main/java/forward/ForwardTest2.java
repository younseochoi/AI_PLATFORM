package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward2")
public class ForwardTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("upperid");
		id = id.toUpperCase();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.print(id+"회원님 반갑습니다.");
		
	}

}
