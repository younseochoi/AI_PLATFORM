package test;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.naverai.NaverInform;
import com.example.naverai.NaverService;

@Controller
public class MyController {

	@Autowired
	@Qualifier("mapservice")
	NaverService mapservice;
	
	@Autowired
	@Qualifier("voiceservice")
	NaverService voiceservice;
	
	@RequestMapping("/myinput")
	public String input() {
		return "test/input";
	}
	
	/*@RequestMapping("/myoutput")
	public ModelAndView output(String request) throws IOException{
		String response = mapservice.test(request);
		
		FileWriter fw = new FileWriter(NaverInform.path + "response.txt");
		fw.write(response);
		fw.close();
		
		String mp3 = voiceservice.test("response.txt");
		ModelAndView mv = new ModelAndView();
		mv.addObject("response", response);
		mv.addObject("mp3", mp3);
		mv.setViewName("test/output");
		return mv;
		
	}*/
	
	@ResponseBody
	@RequestMapping("/myoutput")
	public String output(String request) throws IOException{
		String response = mapservice.test(request);
		
		FileWriter fw = new FileWriter(NaverInform.path + "response.txt");
		fw.write(response);
		fw.close();
		
		String mp3 = voiceservice.test("response.txt");
		
		return "{\"response\":\"" + response + "\", \"mp3\":\"" + mp3 + "\"}";
				
		
	}

}
