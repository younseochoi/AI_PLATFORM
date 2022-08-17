package nonspringmvc;


import javax.servlet.http.HttpServletRequest;

public interface Controller {
	public String handleAndRequest(HttpServletRequest request,  HttpServletRequest response);
}
