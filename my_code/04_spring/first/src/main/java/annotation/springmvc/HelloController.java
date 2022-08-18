package annotation.springmvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	
	@RequestMapping("/hello")
	public ModelAndView at() throws Exception {
		//모델 생성
		HelloDTO dto = new HelloDTO();
		//model 값 저장 
		dto.setMessage("컨트롤러가 jsp로 전달하는 모델입니다.");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", dto);
		mv.setViewName("hello");
//		request.setAttribute("model", dto);
		return mv;
	}

}
