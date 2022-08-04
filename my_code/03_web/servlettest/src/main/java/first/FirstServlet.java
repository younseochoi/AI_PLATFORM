package first;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FirstServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().println("<h1>title</h1>");
	}

}

// 1. 자바서블릿클래스 정의 규칙 - 
// 2. 컴파일 (이클립스 자동) -
// 3. 실행 run as - run on server- 서버 자바문장 실행결과  - 브라우저 실행결과  - url
// servlet = server side applet(자바 클라이언트에서 실행가능했던 프로그램 종류중 하나)