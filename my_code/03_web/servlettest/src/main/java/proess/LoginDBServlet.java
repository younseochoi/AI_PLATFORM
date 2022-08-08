package proess;

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

//	private int connectionDB(String id,String userpassword) {
//		Connection conn= null;
//		int condition = 0;
//		try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		 conn = DriverManager.getConnection
//				("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");
//		 
//		 String sql = "select id, password from member where id = ? ";
//		 PreparedStatement pt = conn.prepareStatement(sql);
//		 pt.setString(1, id);
//		 ResultSet rs = pt.executeQuery();
//		 
//		 String dbid = null, dbpassword=null;
//		 if(rs.next()) {
//			 System.out.println("id w존재!");
//			 condition =1;// id 존재한다.
//			 dbid = rs.getString("id");
//			 dbpassword = rs.getString("password");
//			 if(dbpassword.equals(userpassword)) { //비밀 번호 일치 
//				condition = 2;
//			 }
//		 }else { //id 존재하지 않음 .
//			 condition = 3;
//		 }
//		
//		
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				conn.close();
//			}catch(SQLException e) {
//				
//			}
//		}
//		 return condition;
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String role = request.getParameter("role");
		
		MemberDAO dao = new MemberDAO();

		int condition = dao.selectMember(id, pw);
		
		String output = "";
		
		if(condition == 2) {
			//admin / user
			if(role.equals("admin")) {
				output = id+"계정의 관리자님, 로그인하셨습니다.";
				output += "<ul>"
						+ "<li><a href='AllmemberServlet(doGet)의 url패턴'>모든 사용자 정보 조회</a></li>"
						+ "<li>블랙리스트 관리</li>"
						+ "<li>상품관리</li>"
						+ "</ul>";
			}else if(role.equals("user")) {
				output = id+"계정의 사용자님, 로그인하셨습니다.";
				output += "<ul>"
						+"<li><a href='updatedb.html'>내 정보 수정 </a></li>"
						+"<li><a href='delete?id="+id+"&pw="+pw+"'>회원탈퇴 </a></li>"
						+ "<li>내 정보 조회</li>"
						+ "<li>로그아웃</li>"
						+ "<li>게시판 보기</li>"
						+ "</ul>";
			}
			
		}else if(condition ==1){
			output = "<h1>암호가 다릅니다.</h1>";
			output+= "<a href='logindb.html'>로그인하러 가기 </a>";
			
		}else { //condition 3 
			output = "<h1>등록된 아이디가 존재하지 않습니다.</h1>";
			output+= "<a href='insertdb.html'>회원가입하러 가기 </a>";
		}
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter o = response.getWriter();
		o.print(output);
		
		//브라우저 출력되지 못하고 응답 변경 
		//response.sendRedirect("http://127.0.0.1:8080/servlettest/calc.html");
		//response.sendRedirect("http://multicampus.co.kr");
		
	}

}
