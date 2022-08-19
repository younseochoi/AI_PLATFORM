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
		String register_result = service.registerMember(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("registerresult", register_result);
		mv.setViewName("memberservice");
		return mv;
	}
}
