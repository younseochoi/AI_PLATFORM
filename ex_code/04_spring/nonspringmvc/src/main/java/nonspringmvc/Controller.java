package nonspringmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String handleAndRequest
	(HttpServletRequest request, HttpServletResponse response);
}
