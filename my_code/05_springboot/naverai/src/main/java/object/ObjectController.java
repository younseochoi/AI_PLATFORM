package object;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.naverai.NaverInform;

@Controller
public class ObjectController {

	@Autowired
	@Qualifier("objectservice")
	ObjectService service;
	
	
	@RequestMapping("objectinput")
	public ModelAndView objectInput() {
		File file = new File(NaverInform.path);
		String [] filelist = file.list();
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("object/objectinput");
		return mv;
	}
	
	@RequestMapping("objectresult")
	public ModelAndView objectResult(String image) {
		String objectresult = service.test(image);
		ModelAndView mv = new ModelAndView();
		mv.addObject("objectresult", objectresult);
		System.out.println(objectresult);
		mv.setViewName("object/objectresult");
		return mv;
	}
}
