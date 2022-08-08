package proess;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc") // 컨텍스트 명 생략 
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// service()
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getMethod()); //요청방식 
		System.out.println(request.getRemoteAddr()); // 요청 클라이언트 ip
		
		String n1_str = request.getParameter("num1");
		String n2_str = request.getParameter("num2");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		
		boolean noinput = false;
		
		if(n1_str ==null || n1_str.equals("")||n2_str ==null || n2_str.equals("")) {
			noinput = true;
			
			out.println("<h1><a href='calc.html'>다시 입력하기</a></h1>");
		}else {
			
			int n1 =  Integer.parseInt(n1_str);
			int n2 =  Integer.parseInt(n2_str);
			
			String user = request.getParameter("user");
			System.out.println(user);
			
			String op = request.getParameter("op");
			String result ="";
			if(op.equals("+")) {
				result = n1+op+n2 +"="+(n1+n2);
			}else if(op.equals("-")) {
				result = n1+op+n2 +"="+(n1-n2);
			}else if(op.equals("*")) {
				result = n1+op+n2 +"="+(n1*n2);
			}else if(op.equals("/")) {
				result = n1+op+n2 +"="+(n1/n2);
			}else if(op.equals("%")) {
				result = n1+op+n2 +"="+(n1%n2);
			}else {
				result="유효하지않은 연산자";
			}
			
			response.setContentType("text/html;charset=utf-8");
			out= response.getWriter();
			out.println("<h1>"+result+"</h1>");
			
		}
		
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//이전 할일 문장 
		req.setCharacterEncoding("utf-8"); //브라우저에서받아온 한글 데이터 받아오려면 설정 
		doGet(req, resp);
		//이후 할일 문장 
	}

}
