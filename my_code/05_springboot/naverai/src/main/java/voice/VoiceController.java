package voice;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.naverai.NaverInform;


@Controller
public class VoiceController {
	@Autowired
	@Qualifier("voiceservice")
	VoiceService service;
	
	
	@RequestMapping("voiceinput")
	public ModelAndView objectInput() {
		File file = new File(NaverInform.path);
		String [] filelist = file.list();
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("voice/voiceinput");
		return mv;
	}
	
	@RequestMapping("voiceresult")
	public ModelAndView objectResult(String image,String speaker) {
		String jsonresult= "";
		if(speaker==null) {
			jsonresult = service.test(image);
		}else {
			jsonresult = service.test(image,speaker);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("voiceresult", jsonresult);
		mv.setViewName("voice/voiceresult");
		return mv;
	}
}
