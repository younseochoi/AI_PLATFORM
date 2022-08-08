package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward1")
public class ForwardTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		id = id.toUpperCase();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.print(id+"회원님 반갑습니다.");
		
		request.setAttribute("uppderid", id);
		//request.setAttribute("DTO", dto객체);
//		response.setContentType("text/html;charset=utf-8");
		

		RequestDispatcher rd = request.getRequestDispatcher("forward2");
		//rd.forward(request, response); //print 삭제후 forward 동작 
		rd.include(request, response); //print 삭제후 forward 동작 
		
		//forward 이후 콘솔은 출력 o 
				System.out.println("이건 출력되나요?");
	}

}
