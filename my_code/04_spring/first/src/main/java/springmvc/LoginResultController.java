package springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginResultController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginDTO dto = new LoginDTO();
		dto.setId(request.getParameter("id"));
		dto.setPassword(Integer.parseInt(request.getParameter("pw")));
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", dto);
		mv.setViewName("loginresult");
		return mv;
	}
}
