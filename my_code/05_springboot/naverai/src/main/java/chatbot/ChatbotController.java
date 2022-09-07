package chatbot;

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
public class ChatbotController {

	@Autowired
	@Qualifier("chatbotservice")
	ChatbotService service;
	
	@Autowired
	@Qualifier("voiceservice")
	NaverService service2;
	
	@RequestMapping("/chatbotinput")
	public String input() {
		return "chatbot/chatbotinput";
	}
	
	@RequestMapping("/chatbotresult")
	public ModelAndView output(String request,String event) {
		String response="";
		if(event.equals("답변")) {
			response=  ((ChatbotService)service).test(request, "send");
		}else {
			response = service.test(request);
		}
		ModelAndView mv= new ModelAndView();
		mv.addObject("response", response);
		mv.setViewName("chatbot/chatbotoutput");
		return mv;
	}
	
	@RequestMapping("chatbotinputajax")
	public String ajax() {
		return "chatbot/chatbotajax";
	}
	
	@ResponseBody
	@RequestMapping("chatbotresultajax")
	public String outputajax(String request, String event) {
		String response = "";
		if(event.equals("답변")) {
			response = ((ChatbotService)service).test(request, "send");
		}
		else {
			response = service.test(request);
		}
		return response;
	}
	
	@ResponseBody
	@RequestMapping("/chatbotvoice")
	public String chatbotvoice(String text) throws IOException{
		FileWriter fw = new FileWriter(NaverInform.path + "text.txt");
		fw.write(text);
		fw.close();
		
		String mp3 = service2.test("text.txt");
		return "{\"mp3\":\"" + mp3 + "\"}";
	}
}
