package annotation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	//@RequestMapping(value="/member", method=RequestMethod.GET)
	@GetMapping("/member")
	public String start() {
		return "memberhobby";//WEB-INF/views/*.jsp
	}
	@PostMapping("/member")
	public ModelAndView end(@ModelAttribute("dto") MemberHobbyDTO dto) {
		//html입력-dto동일명변수로 자동저장 - view로 전달 
		ModelAndView mv = new ModelAndView();
		if(dto.getAge() >= 20) {
			mv.addObject("result", "성인입니다");
		}
		else {
			mv.addObject("result", "미성년입니다");
		}
		mv.setViewName("memberhobbyresult");//mvc 직접 구현 forward ${param.id}
		return mv;
	}
/*	@PostMapping("/member")
	public ModelAndView end(String id, int password, int age, String[] hobby) {
		ModelAndView mv = new ModelAndView();
		if(age >= 20) {
			mv.addObject("result", "성인입니다");
		}
		else {
			mv.addObject("result", "미성년입니다");
		}
		mv.setViewName("memberhobbyresult");//mvc 직접 구현 forward ${param.id}
		return mv;
	}*/
}
