package annotation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
//	/member : get요청
//	MemberController – start() 호출 – memberhobby.jsp 뷰 응답
//	/member : post요청
//	MemberController – end(String id, int password, int age, String[] hobby) 호출 –
//	id, password, age, hobby (다수개) 읽어서
//	age 20 이상이면 "성인입니다" 값을 모델로 저장 age 20 미만이면 "미성년입니다" 값을 모델로 저장 memberhobbyresult.jsp 뷰 응답
//	id, age, hobby 출력 모델값 출력
	
	@GetMapping("/member")
	public String start() {
		return "memberhobby";
	}
	
	@PostMapping("/member")
	public ModelAndView end(@ModelAttribute("id") String id,@ModelAttribute("password") int password,@ModelAttribute("age") int age, @RequestParam("hobby") String[] hobby) {
		ModelAndView mv= new ModelAndView();
		if(age>=20) {
			mv.addObject("model", "성인입니다.");
		}else {
			mv.addObject("model", "미성년입니다.");
		}
		mv.setViewName("memberhobbyresult");
		
//		for(String s : hobby) {
//			System.out.println(s);
//		}
//		System.out.println(hobby.length);
		mv.addObject("hobby", hobby);
		return mv;
	}
	
	
}
