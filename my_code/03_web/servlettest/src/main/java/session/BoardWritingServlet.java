package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/boardwriting")
public class BoardWritingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션 객체 리턴 
		HttpSession session = request.getSession();
		//세션 객체 저장 sessionid 변수 
		String sessionid = (String) session.getAttribute("sessionid");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		String printing = "<h1>글쓰기 폼</h1>";
		printing+= "<table border=1>";
		printing+= "<tr><td>제목</td><td><input type =text name='title'></td></tr>";
		printing+= "<tr><td>내용</td><td><textarea nmae='contents' cols=50 rows=5></textarea></td></tr>";
		printing+= "<tr><td>작성자</td><td><input type =text name='writer' value="+sessionid+" readonly ></td></tr>";
		printing+= "</table>";
		
		o.print(printing);
	}

}
