package login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {
	
	@RequestMapping("/")
	public String index() {
		return "home";
	}
	
	@RequestMapping(value="/backendlogin", method = RequestMethod.GET)
	public String loginform() {
		return "login";
	}
	
	@ResponseBody
	@RequestMapping(value="/backendlogin", produces= {"application/json;charset=utf-8"}  )
	public String loginresult(String id, int password) {

		String result = "";

		if(id.equals("abcd")&&password ==1234) {
			result = "login ok";
		}else {
			result= "login fail";
		}
		return "{\"result\" : \""+result+"\"}";
				
	}
}
