package annotation.springmvc;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ListController{

	@RequestMapping("/list")
	public ModelAndView handleRequest() throws Exception {
		ArrayList<HelloDTO> list = new ArrayList<HelloDTO>();
		for(int i=0;i<5;i++) {
			list.add(new HelloDTO());
			list.get(i).setMessage((i+1)+"번째 HelloDTO 객체입니다.");
		}
//		for(int i=0;i<5;i++) {
//			list.get(i).setMessage((i+1)+"번째 HelloDTO 객체입니다.");
//		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("list");
//		request.setAttribute("list", list);
		return mv;
	}
}
