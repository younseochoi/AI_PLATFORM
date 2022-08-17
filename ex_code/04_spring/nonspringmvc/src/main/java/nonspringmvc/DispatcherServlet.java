package nonspringmvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8080/nonsptingmvc/hello
// controller=model=jsp

//http://localhost:8080/nonsptingmvc/list
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트 서버 진입 대문
		String uri = request.getRequestURI(); //   /nonspringmvc/a/b/c/hello
		String uri_array[] = uri.split("/");
		String result = uri_array[uri_array.length -1]; // hello
		//System.out.println(result);
		
		HandlerMapping mappings = new HandlerMapping(); // put("list", new ListController().)
		Controller con = mappings.getController(result);
		System.out.println(con);
		String viewname = con.handleAndRequest(request, response); //HelloDTO모델 값 저장 - hellp.jsp
		//System.out.println(viewname);
		//뷰이름 리턴
		RequestDispatcher rd = request.getRequestDispatcher(viewname);
		rd.forward(request, response);
		
	}

}
