package ocr;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.naverai.NaverInform;

import voice.VoiceService;

@Controller
public class OCRController {
	
	@Autowired
	@Qualifier("ocrservice")
	OCRService service;
	
	
	@RequestMapping("ocrinput")
	public ModelAndView ocrInput() {
		File file = new File(NaverInform.path);
		String [] filelist = file.list();
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("ocr/ocrinput");  //gif jpg png jfif
		return mv;
	}
	
	@RequestMapping("ocrresult")
	public ModelAndView ocrResult(String textimage) {
		String jsonresult= "";
		jsonresult = service.test(textimage);

		ModelAndView mv = new ModelAndView();
		mv.addObject("ocrresult", jsonresult);//ocr 결과
		mv.setViewName("ocr/ocrresult");
		return mv;
	}
}
