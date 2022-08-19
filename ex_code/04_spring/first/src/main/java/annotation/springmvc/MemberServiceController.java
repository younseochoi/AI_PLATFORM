package annotation.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import annotation.memberservice.MemberDTO;
import annotation.memberservice.MemberService;

@Controller
public class MemberServiceController {
	@Autowired
	@Qualifier("service1")
	MemberService service ;
	
	@RequestMapping("/memberservice")
	public ModelAndView memberservice(MemberDTO dto){
		String registerresult = service.registerMember(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("registerresult", registerresult);
		mv.setViewName("memberservice");
		return mv;

	}
}

//매개변수를 받지 않는 public void registerMember(); 는 굳이 남겨둘 이유가 있나요?

//MemberDAO--> CRUD 기능 완료 구현


