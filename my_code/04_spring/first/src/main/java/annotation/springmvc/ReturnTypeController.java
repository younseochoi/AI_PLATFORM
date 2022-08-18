package annotation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnTypeController {
	
	//모델 뷰 리턴
	@RequestMapping("/a")
	public ModelAndView a() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", "a메소드 호출결과");
		mv.setViewName("aa");
		return mv;
	}
	
	//모델 없고 뷰 리턴 
	@RequestMapping("/b")
	public String b() {
		return "bb";
	}
	@RequestMapping("/c")
	public void cc() {
		//모델없고 뷰 c.jsp 자동 호출
	}
	
	@RequestMapping("/d")
	public String d(){
		return "aa";
	}
	
	@RequestMapping("/e")
	public String e(){
		// /a 인 매핑 메소드 호출
		//메소드 추가 정의
		return "redirect:/a";
	}
}
