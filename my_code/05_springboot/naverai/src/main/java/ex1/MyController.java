package ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.naverai.NaverInform;

import voice.VoiceService;

@Controller
public class MyController {

	@Autowired
	@Qualifier("mapservice")
	MapService mapservice;
	
	@Autowired
	@Qualifier("voiceservice")
	VoiceService voiceservice;
	
	@RequestMapping("/myinput")
	public String myInput() {
		return "ex1/input";
	}
	
//	@RequestMapping("/myoutput")
//	public ModelAndView myOutput(String question) throws IOException {
//		ModelAndView mv= new ModelAndView();
//		String response = mapservice.test(question);
//		System.out.println(response); //ok
//		String name = "question"+UUID.randomUUID().toString()+".txt";
//		OutputStream os = new FileOutputStream(NaverInform.path+name);
//		byte []  by = response.getBytes();
//		os.write(by);
//		String jsonresult = voiceservice.test(name);
//		mv.setViewName("ex1/output");
//		mv.addObject("textresult", response);
//		mv.addObject("voiceresult", jsonresult);
//		return mv;
//	}
	
	@ResponseBody
	//@RequestMapping("/myoutput")
	@RequestMapping(value="/myoutput", produces= {"application/json;charset=utf-8"})
	public String myOutput(String question) throws IOException {
		ModelAndView mv= new ModelAndView();
		String response = mapservice.test(question);
		System.out.println(response); //ok
		String name = "question.txt";
		OutputStream os = new FileOutputStream(NaverInform.path+name);
		byte []  by = response.getBytes();
		os.write(by);
		String jsonresult = voiceservice.test(name);
		mv.setViewName("ex1/output");
		System.out.println(response+":: "+jsonresult);
		
//		mv.addObject("textresult", response);
//		mv.addObject("voiceresult", jsonresult);
		return "{\"textresult\" : \""+response+"\", \"voiceresult\" : \""+jsonresult+"\"}";
	}
}
