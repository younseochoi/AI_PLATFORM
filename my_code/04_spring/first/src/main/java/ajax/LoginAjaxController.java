package ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginAjaxController {

	@GetMapping("/loginajax")
	public String loginform() {
		return "ajax/loginform";
	}
	
	@ResponseBody
	@RequestMapping(value="/loginajax", produces= {"application/json;charset=utf-8"}  )
	public String loginresult(String id, int password) {
		String model= "";
		if(id.equals("ajax") && password == 1234) {
			model = "login success-로그인 성공";
		}else {
			model = "login fail- 로그인 실패";
		}
		
		return "{\"process\" : \""+model+"\"}";
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("loginresult", model);
//		mv.setViewName("ajax/loginresult");
//		return mv;
	}
	
}
