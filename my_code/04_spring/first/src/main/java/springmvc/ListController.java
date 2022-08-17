package springmvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ListController implements Controller {


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
