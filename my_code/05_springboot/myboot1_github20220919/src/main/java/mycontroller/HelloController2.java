package mycontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController2 {
	
	@RequestMapping("/helloboot2")
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("model","헬로우 스프링 부트2");
		mv.setViewName("hello");
		return mv;
	}
}
