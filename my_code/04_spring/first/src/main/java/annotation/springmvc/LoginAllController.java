package annotation.springmvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginAllController {
		//모델 없고 loginform.jsp 뷰
//		@RequestMapping("/loginform")
//		public String loginform() {
//			return "loginform";
//		}
	
	/*	
	 * test1
	 * //id , pw loginDTO 저장 loginresult.jsp 뷰
		@RequestMapping("/loginresult")
		public ModelAndView loginresult(HttpServletRequest request) {
			LoginDTO dto = new LoginDTO();
			dto.setId(request.getParameter("id"));
			dto.setPassword(Integer.parseInt(request.getParameter("pw")));
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("member", dto);
			mv.setViewName("loginresult");
			return mv;
		}
		*/
//		//test2 
//		//id , pw loginDTO 저장 loginresult.jsp 뷰
//		@RequestMapping("/loginresult")
//		public ModelAndView loginresult(String id, int pw) {
//			System.out.println(id+" "+pw);
//			LoginDTO dto = new LoginDTO();
//			dto.setId(id);
//			dto.setPassword(pw);
//					
//			ModelAndView mv = new ModelAndView();
//			mv.addObject("member", dto);
//			mv.setViewName("loginresult");
//			return mv;
//		}
		
//		//test3
//		//id , pw loginDTO 저장 loginresult.jsp 뷰
//		@RequestMapping("/loginresult")
//		//두군데의 jsp 의 폼에서 호출했을시
//		//a.jsp -> <input name="id"
//		//b.jsp -> <input name="name" 이 같은 메소드를 호출한다면 ?
//		public ModelAndView loginresult(@RequestParam("id") String name, int pw) {
//			System.out.println(name+" "+pw);
//			LoginDTO dto = new LoginDTO();
//			dto.setId(name);
//			dto.setPassword(pw);
//							
//			ModelAndView mv = new ModelAndView();
//			mv.addObject("member", dto);
//			mv.setViewName("loginresult");
//			return mv;
//		}
		
//		//test4
//		//id , pw loginDTO 저장 loginresult.jsp 뷰
//		@RequestMapping("/loginresult")
//		//두군데의 jsp 의 폼에서 호출했을시
//		//a.jsp -> <input name="id"
//		//b.jsp -> <input name="name" 이 같은 메소드를 호출한다면 ?
//		public ModelAndView loginresult(LoginDTO dto) {
//			System.out.println(dto.getId()+" "+dto.getPassword());				
//			ModelAndView mv = new ModelAndView();
//			mv.addObject("member", dto);
//			mv.setViewName("loginresult");
//			return mv;
//		}		
		
		//test5
		//id , pw loginDTO 저장 loginresult.jsp 뷰
//		@RequestMapping("/loginresult")
//		//두군데의 jsp 의 폼에서 호출했을시
//		//a.jsp -> <input name="id"
//		//b.jsp -> <input name="name" 이 같은 메소드를 호출한다면 ?
//		public String loginresult(@ModelAttribute("member") LoginDTO dto) {
//			System.out.println(dto.getId()+" "+dto.getPassword());				
//			//ModelAndView mv = new ModelAndView();
//			//mv.addObject("member", dto);
//			//mv.setViewName("loginresult");
//			return "loginresult";
//		}		
	
	//test6
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String loginform() { //get방식
//		return "loginform";
//	}	
//	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	//두군데의 jsp 의 폼에서 호출했을시
//	//a.jsp -> <input name="id"
//	//b.jsp -> <input name="name" 이 같은 메소드를 호출한다면 ?
//	public String loginresult(@ModelAttribute("member") LoginDTO dto) {
//		System.out.println(dto.getId()+" "+dto.getPassword());				
//		//ModelAndView mv = new ModelAndView();
//		//mv.addObject("member", dto);
//		//mv.setViewName("loginresult");
//		return "loginresult";
//	}		
	
	//test 7 
	@GetMapping("/login")
	public String loginform() { //get방식
		return "loginform";
	}	
	
	@PostMapping("/login")
	//두군데의 jsp 의 폼에서 호출했을시
	//a.jsp -> <input name="id"
	//b.jsp -> <input name="name" 이 같은 메소드를 호출한다면 ?
	public String loginresult(@ModelAttribute("member") LoginDTO dto) {
		System.out.println(dto.getId()+" "+dto.getPassword());				
		//ModelAndView mv = new ModelAndView();
		//mv.addObject("member", dto);
		//mv.setViewName("loginresult");
		return "loginresult";
	}		
	
}
