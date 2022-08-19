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
	public void insertform() {
		//memberdbinsert.jsp 폼 입력
	}
	
	@PostMapping("/memberdbinsert")
	public ModelAndView insertresult(MemberDTO dto) {
		String registerresult = service.registerMember(dto);  //dao.selectMember() --> dao.insertMember()
		ModelAndView mv = new ModelAndView();
		mv.addObject("registerresult", registerresult);
		mv.setViewName("memberdbresult");
		return mv;
	}
}








