package csr;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.naverai.NaverInform;
import com.example.naverai.NaverService;

@Controller
public class CSRController {
	@Autowired
	@Qualifier("csrservice")
	NaverService service;
	
	@RequestMapping("/csrinput")
	public ModelAndView objectinput() {
		File f = new File(NaverInform.path);
		String [] filelist = f.list();
		org.springframework.web.servlet.ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("csr/csrinput");
		return mv;
	}
	
	@RequestMapping("/csrresult")	
	public ModelAndView objectresult(String image, String lang) {
		String jsonresult = null;
		if(lang == null) {
			jsonresult = service.test(image);
		}
		else {
			jsonresult = ((CSRService)service).test(image, lang);
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("csrresult", jsonresult);//{"text":"xxxxxxx"}
		mv.setViewName("csr/csrresult");
		return mv;
	}
	
	
}





