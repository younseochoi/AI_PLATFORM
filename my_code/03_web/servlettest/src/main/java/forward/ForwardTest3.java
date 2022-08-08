package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;

@WebServlet("/forward3")
public class ForwardTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPassword(Integer.parseInt(pw));
		dto.setPhone(phone);
		dto.setName(name);
		dto.setEmail(email);
		dto.setRegdate("2022-08-08");
		
		
		request.setAttribute("DTO", dto);
//		response.setContentType("text/html;charset=utf-8");
		

//		RequestDispatcher rd = request.getRequestDispatcher("회원가입처리서블릿");
//		RequestDispatcher rd = request.getRequestDispatcher("수정처리서블릿");
//		RequestDispatcher rd = request.getRequestDispatcher("자기정보조회서블릿");
		RequestDispatcher rd = request.getRequestDispatcher("forward4"); //다른 서블릿으로도 전송하기위해 (재사용)
		
		
		rd.forward(request, response); //print 삭제후 forward 동작 
		//rd.include(request, response); //print 삭제후 forward 동작 
		
	}

}
