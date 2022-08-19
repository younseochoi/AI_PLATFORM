package springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginResultController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인요청 정보 입력
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		//모델 생성
		LoginDTO dto = new LoginDTO();
		dto.setId(id);
		dto.setPassword(Integer.parseInt(password));
		//전달
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginresult", dto);
		mv.setViewName("loginresult");
		return mv;
	}

}
