package process;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/memberlist")
public class AllMemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//관리자로 로그인상태에서 요청
		//처리
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> memberlist = dao.selectAllMember();
		System.out.println(memberlist.size());//14
		//TABLE태그형태
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		String output = "";
		output = "<style> table, td {border : 2px solid blue} </style>";
		output += "<table>";
		output +="<tr><td>아이디</td><td>이름</td><td>폰</td><td>이메일</td><td>가입날짜</td></tr>";
		for(int i = 0; i <memberlist.size(); i++) {
			MemberDTO dto = memberlist.get(i);
			output += "<tr><td>" + dto.getId() + "</td><td>" + dto.getName() 
			+ "</td><td>" + dto.getPhone() + "</td><td>" + dto.getEmail()
			+ "</td><td>" + dto.getRegdate() + "</td></tr>";
		}
		
		output += "</table>";
		o.print(output);
	}

}







