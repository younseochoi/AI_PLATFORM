package object;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.naverai.NaverInform;
import com.example.naverai.NaverService;

@Controller
public class ObjectController {
	@Autowired
	@Qualifier("objectservice")
	NaverService service;
	
	@RequestMapping("/objectinput")
	public ModelAndView objectinput() {
		File f = new File(NaverInform.path);
		String [] filelist = f.list();
		org.springframework.web.servlet.ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("object/objectinput");
		return mv;
	}
	
	@RequestMapping("/objectresult")	
	public ModelAndView objectresult(String image) {
		String jsonresult = service.test(image);
		ModelAndView mv = new ModelAndView();
		mv.addObject("objectresult", jsonresult);
		mv.setViewName("object/objectresult");
		return mv;
	}
	
	
}
