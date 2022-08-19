package annotation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController{
	@RequestMapping("/hello")
	public ModelAndView a() {
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




