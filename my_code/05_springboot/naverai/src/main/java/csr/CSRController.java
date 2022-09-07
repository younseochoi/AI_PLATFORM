package csr;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.naverai.NaverInform;

@Controller
public class CSRController {

	@Autowired
	@Qualifier("csrservice")
	CSRService service;
	
	
	@RequestMapping("csrinput")
	public ModelAndView objectInput() {
		File file = new File(NaverInform.path);
		String [] filelist = file.list();
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("csr/csrinput");
		return mv;
	}
	
	@RequestMapping("csrresult")
	public ModelAndView objectResult(String image,String lang) {
		String jsonresult= "";
		if(lang==null) {
			jsonresult = service.test(image);
		}else {
			jsonresult = service.test(image,lang);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("csrresult", jsonresult);
		mv.setViewName("csr/csrresult");
		return mv;
	}
}
