package chatbot;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.naverai.NaverInform;
import com.example.naverai.NaverService;

@Controller
public class PizzaController {
	@Autowired
	PizzaDTO dto;
	
	@Autowired
	@Qualifier("chatbotservice")
	NaverService service;
	
	@Autowired
	@Qualifier("voiceservice")
	NaverService service2;
	
	@RequestMapping("/pizzainput")
	public String input() {
		return "chatbot/pizza";
	}
	
	@ResponseBody
	@RequestMapping("/pizzaresult")
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
	//http://localhost:8082/chatbotresultajax?request=&event=aaa
	@ResponseBody
	@RequestMapping("/pizzavoice")
	public String chatbotvoice(String text) throws IOException{
		FileWriter fw = new FileWriter(NaverInform.path + "text.txt");
		fw.write(text);
		fw.close();
		
		String mp3 = service2.test("text.txt");
		return "{\"mp3\":\"" + mp3 + "\"}";
	}
	

	
	@ResponseBody
	@RequestMapping("/pizzaprice")
	public PizzaDTO calcpizzaprice(String kind, String size, String telnum) {
		String menu[] = {"콤비네이션피자", "하와이안피자", "고구마피자", "감자피자"};
		int prices[] = {10000, 12000, 15000, 13000};// '소' 사이즈 가격
		// '중'-5000 추가, '대'-10000 추가 , '특대'-15000 추가
		//피자 가격 계산
		int price = 0;
		for(int i = 0; i < menu.length; i++) {
			if(kind.equals(menu[i])) {
				if(size.equals("중")) { price = 	prices[i] + 5000; }
				else if(size.equals("대")) { price = 	prices[i] + 10000; }
				else if(size.equals("특대")) { price = 	prices[i] + 15000; }
				else { price = prices[i];	}
			}
		}
		dto.setKind(kind);
		dto.setPrice(price);
		dto.setSize(size);
		dto.setTelnum(telnum);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년도MM월dd일HH시mm분ss초");
		Date now = new Date();
		String ordertime = sdf.format(now);
		dto.setOrdertime(ordertime);
		return dto;
		// PizzaDTO 객체 저장(kind, size, telnum, price) - 리턴

	}
}







