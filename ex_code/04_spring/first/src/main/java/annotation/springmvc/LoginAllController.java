package annotation.springmvc;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginAllController {
//test6   
	//@RequestMapping(value="/login",  method=RequestMethod.GET)
	@GetMapping("/login")
	public String loginform() { //get방식 폼 화면 응답
		return "loginform";
	}
	//@RequestMapping(value="/login",  method=RequestMethod.POST)	
	@PostMapping("/login")
	public String loginresult(@ModelAttribute("loginresult") LoginDTO dto) {//post방식 암호
		System.out.println(dto.getId() + ":" + dto.getPassword());
		return "loginresult";
	}
	
	// 모델 없고 loginform.jsp 뷰 
/*	@RequestMapping("/loginform") //get+post 모두 요청 가능
	public String loginform() {
		return "loginform";
	}
*/	
	//test5
/*	@RequestMapping("/loginresult")
	public String loginresult(@ModelAttribute("loginresult") LoginDTO dto) {
		
		System.out.println(dto.getId() + ":" + dto.getPassword());
		dto.setId("수정");
		
		return "loginresult";
	}
	*/
	//test4
/*	@RequestMapping("/loginresult")
	public ModelAndView loginresult(LoginDTO dto) {
		System.out.println(dto.getId() + ":" + dto.getPassword());
		//전달
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginresult", dto);
		mv.setViewName("loginresult");
		return mv;
	}	*/
	//test3
/*	@RequestMapping("/loginresult")
	public ModelAndView loginresult(@RequestParam(value="id", required = false, defaultValue ="" ) String name, int password) {
		System.out.println(name+":"+password);
		//모델 생성
		LoginDTO dto = new LoginDTO();
		dto.setId(name);
		dto.setPassword(password);
		//전달
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginresult", dto);
		mv.setViewName("loginresult");
		return mv;
	}	*/
	//test2
/*	@RequestMapping("/loginresult")
	public ModelAndView loginresult(String id, int password) {
		System.out.println(id+":"+password);
		//모델 생성
		LoginDTO dto = new LoginDTO();
		dto.setId(id);
		dto.setPassword(password);
		//전달
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginresult", dto);
		mv.setViewName("loginresult");
		return mv;
	}	*/
// ID, PW LoginDTO 모델 저장 loginresult.jsp 뷰	
	//test1
/*	@RequestMapping("/loginresult")
	public ModelAndView loginresult(HttpServletRequest request) {
		//로그인요청 정보 입력
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		//모델 생성
		LoginDTO dto = new LoginDTO();
		dto.setId(id);
		dto.setPassword(Integer.parseInt(password));
		//전달
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginresult", dto);
		mv.setViewName("loginresult");
		return mv;
	}*/
	

	
	
}

//1개 기능 메소드들 
//회원관리컨트롤러 -  crud 메소드들 - 1개 컨트롤러 

