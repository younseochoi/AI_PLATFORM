package proess;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/insertdb")
public class InsertDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String output= "";
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPassword(Integer.parseInt(pw));
		dto.setEmail(email);
		dto.setPhone(phone);
		dto.setName(name);
		MemberDAO dao =  new MemberDAO();
		
		
		int condition = dao.selectMember(id, pw);
		if(condition == 3) {
			int rows = dao.insertMember(dto);
			if(rows==1) {
				output = "<h1>정상적으로 회원가입되었습니다.</h1>";
				output+="<a href='logindb.html'>로그인 하러가기</a>";
			}
		}else {
//			"중복되었습니다 insertdb링크 "
			output = "<h1>아이디가 중복되었습니다.</h1>";
			output+="<a href='insertdb.html'>다시 회원가입 하러가기</a>";

		}
		out.println(output);
		
	}

}
