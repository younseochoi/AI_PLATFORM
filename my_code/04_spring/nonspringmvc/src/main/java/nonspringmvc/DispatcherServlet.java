package nonspringmvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 클라이언트 입장에서 처음만나는 대문
		String uri = request.getRequestURI();
		String[] uri_array = uri.split("/");
		String result = uri_array[uri_array.length-1];
		System.out.println(result);
		
		HandlerMapping mappings = new HandlerMapping();
		Controller con = mappings.getController(result);
		String viewname = con.handleAndRequest(request, request); //HelloDTO 모델값저장, hello.jsp 리턴
		RequestDispatcher rd = request.getRequestDispatcher(viewname);
		rd.forward(request, response);
	}

}
