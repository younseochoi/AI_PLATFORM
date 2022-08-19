package annotation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnTypeController {
	@RequestMapping("/a")
	public ModelAndView a(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", "a메소드호출결과");
		mv.setViewName("aa");
		return mv;
	}
	// 모델 없고 view 이름 리턴
	@RequestMapping("/b")
	public String b(){
		return "bb";
	}
	@RequestMapping("/c")
	public void cc(){
		//모델 없고 뷰이름 "자동" mapping url - c.jsp
	}
	@RequestMapping("/d")
	public String d(){
		return "aa";
	}
	@RequestMapping("/e")
	public String e(){
		// a.jsp 뷰 리턴 의미가 아니라 매핑url /a 메소드 호출
		//  메소드 추가 정의
		return "redirect:/a";
	}
}




