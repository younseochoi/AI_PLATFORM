package voice;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.naverai.NaverInform;
import com.example.naverai.NaverService;


@Controller
public class VoiceController {
	@Autowired
	@Qualifier("voiceservice")
	NaverService service;
	
	@RequestMapping("/voiceinput")
	public ModelAndView objectinput() {
		File f = new File(NaverInform.path);
		String [] filelist = f.list();
		org.springframework.web.servlet.ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", filelist);
		mv.setViewName("voice/voiceinput");
		return mv;
	}
	
	@RequestMapping("/voiceresult")	
	public ModelAndView objectresult(String image, String speaker) {
		String jsonresult = null;
		if(speaker == null) {
			jsonresult = service.test(image);
		}
		else {
			jsonresult = ((VoiceService)service).test(image, speaker);
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("voiceresult", jsonresult);//mp3파일명리턴( 서비스 수행- mp3파일 생성)
		mv.setViewName("voice/voiceresult");
		return mv;
	}
	
	
}
