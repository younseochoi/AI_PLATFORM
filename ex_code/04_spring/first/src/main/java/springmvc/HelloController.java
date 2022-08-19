package springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//model 생성
		HelloDTO dto = new HelloDTO();
		//MODEL 값 저장
		dto.setMessage("컨트롤러가 jsp로 전달하는 모델입니다.");
		
		ModelAndView mv = new ModelAndView();
		//request.setAttribute("model", dto);
		mv.addObject("model", dto);
		mv.setViewName("hello");//뷰경로,확장자포함x-설정파일
		return mv;
	}

}




