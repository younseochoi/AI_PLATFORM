package ocr;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.naverai.NaverInform;
import com.example.naverai.NaverService;

import voice.VoiceService;

@Controller
public class OCRController {
	@Autowired
	@Qualifier("ocrservice")
	NaverService service;
	
	@RequestMapping("/ocrinput")
	public ModelAndView objectinput() {
		File f = new File(NaverInform.path);
		String [] filelist = f.list();
		org.springframework.web.servlet.ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("ocr/ocrinput");// gif jpg png jfif
		return mv;
	}
	
	@RequestMapping("/ocrresult")	
	public ModelAndView objectresult(String textimage) {
		String jsonresult = service.test(textimage);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("ocrresult", jsonresult);//json
		mv.setViewName("ocr/ocrresult");
		return mv;
	}
	
	
	
}
