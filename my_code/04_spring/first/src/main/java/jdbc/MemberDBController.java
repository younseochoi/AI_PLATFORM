package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberDBController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("/memberdbinsert")
	public void insesrtform() {
		
	}
	
	@PostMapping("/memberdbinsert")
	public ModelAndView insesrtresult(MemberDTO dto) {
		String register_result = service.registermember(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("registerresult", register_result);
		mv.setViewName("memberdbresult");
		return mv;
		
	}
}
