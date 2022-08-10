package process;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		String output = "";
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");//컬럼변수 password
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		//
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPassword(Integer.parseInt(pw));
		dto.setName(name);
		dto.setPhone(phone);
		dto.setEmail(email);
		MemberDAO dao = new MemberDAO();
		//member 테이블 같은 id 레코드 여러개 생기는 이유 - pk 제약조건 설정x
		//id 기존 member 다른 레코드 중복 검사
		int condition = dao.selectMember(id, pw);// 1(id o pw x), 2(id, pw o), 3(id x)
		if(condition == 3) {
			int rows = dao.insertMember(dto);
			if(rows == 1) {
				output = "<h1>정상적으로 회원가입되셨습니다. <a href=logindb.html> 로그인하러 가기</a></h1>";
			}
		}else {
			output = "<h1>아이디는 중복되었습니다. <a href=insertdb.html> 다시 가입하러 가기</a></h1>";
		}
		
		o.println(output);
	}

}
