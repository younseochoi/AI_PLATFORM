package ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginAjaxController {
	@GetMapping("/loginajax")
	public String loginform() {
		return "ajax/loginform";
	}
	
	
	//주소표시줄 http:.../loginajax?id=aaa&password=1234
	
	//@ResponseBody 
	@PostMapping(value="/loginajax" , produces = {"application/json;charset=utf-8"})
	public @ResponseBody String loginresult(String id, int password) {
		// id - ajax, passowrd - 1234 이면 정상 로그인 사용자 모델값 저장
		// 아니면 비정상 로그인 사용자 모델값 저장
		// ajax/loginresult.jsp
		String model = "";
		if(id.equals("ajax") && password == 1234) {
			model = "login success-로그인성공";
		}
		else {
			model = "login fail-로그인실패";
		}
		
		return "{\"process\" : \"" + model + "\"}"; //컨트롤러 내부 잘못된 json 형식인데도 오류발생x
		//loginform.jsp 뷰 그대로 , 결과받아서 표현
		
	//	ModelAndView mv = new ModelAndView();
	//	mv.addObject("loginresult", model);
	//	mv.setViewName("ajax/loginresult");
	//	return mv;
	}
}
