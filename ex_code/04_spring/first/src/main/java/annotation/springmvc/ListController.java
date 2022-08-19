package annotation.springmvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController{
	@RequestMapping("/list")
	public ModelAndView b() {
		ArrayList<HelloDTO> list = new ArrayList();
		for(int i = 1; i <=5; i++) {
			HelloDTO dto = new HelloDTO();
			dto.setMessage("리스트" + i);
			list.add(dto);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);//<% request.getAttribute("list")
		mv.setViewName("list");
		return mv;
	}

}
