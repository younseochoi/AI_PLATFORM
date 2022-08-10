package process;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

@WebServlet("/logindb")
public class LoginDBServlet extends HttpServlet {
// 서블릿에서 요청받은 값 이용 + 콘솔 입력 main 실행 호출

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String role = request.getParameter("role");
		
		MemberDAO dao = new MemberDAO();
		int condition = dao.selectMember(id, pw);
		
		//id 존재 - pw 맞는다- 2 
		//id 존재 - pw 다르다 --> 1  logindb.html 링크
		// id 존재 x ---> 3 inertmember.html - 회원가입 폼 입력 - insert
		
		String output = "";
		if(condition == 2) {
		if(role.equals("admin")) {
			output = id + " 계정의 관리자님 로그인하셨습니다 <br>";
			output += "<ul><li> <a href='memberlist'>모든 사용자 정보 조회</a></li>";
			output += "<li> 블랙리스트 관리 </li>";
			output += "<li> 상품관리 </li></ul>";			
		}
		else if(role.equals("user")) {
			output = id + " 계정의 사용자님 로그인하셨습니다 ";
			output += "<ol><li> <a href='updatedb.html'> 내정보 수정 </a></li>";
			output += "<li> <a href='delete?id=" + id + "&pw=" + pw + "'> 회원 탈퇴 </a> </li>";
			output += "<li> 게시판 보기 </li></ol>";
		}
		}//condition == 2
		else if(condition == 1) {
			output = "<h3>암호가 다릅니다</h3>";
			output += "<a href='logindb.html'> 로그인하러 가기</a>";
		}//condition == 1
		else {
			output = "<h3>회원가입하신 적이 없네요</h3>";
			output += "<a href='insertdb.html'> 회원가입하러 가기</a>";
		}//condition == 3
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.print(output);
	}

}

