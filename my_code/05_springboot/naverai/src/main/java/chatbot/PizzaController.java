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
import org.springframework.web.servlet.ModelAndView;

import com.example.naverai.NaverInform;
import com.example.naverai.NaverService;



@Controller
public class PizzaController {

	@Autowired
	@Qualifier("chatbotservice")
	ChatbotService service;
	
	@Autowired
	@Qualifier("pizzaservice")
	PizzaService pizzaService;
	
	@Autowired
	@Qualifier("voiceservice")
	NaverService service2;

	@Autowired
	PizzaDTO dto;
	
	@RequestMapping("/pizzainput")
	public String input() {
		return "chatbot/pizza";
	}
	
	@ResponseBody
	@RequestMapping("pizzaresult")
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
	public PizzaDTO calPizzaPrice(String kind, String size, String telnum) {
		System.out.println(kind +" :: "+size +" :: "+telnum);
		String [] menu = {"콤비네이션피자", "하와이안피자","고구마피자","감자피자"};
		int prices[] = {10000,12000,15000,13000};
		int price = 0;
		// 중 5000원 추가 /대 10000원 추가 / 특대 15000원 추가
		for(int i=0;i<menu.length;i++) {
			if(menu[i].equals(kind)) {
				if(size.equals("중")) {
					price = prices[i]+5000;
				}else if(size.equals("대")) {
					price = prices[i]+10000;
				}else if(size.equals("특대")) {
					price = prices[i]+15000;
				}else {
					price =prices[i];
				}
			}
		}
		dto.setKind(kind);
		dto.setPrice(price);
		dto.setSize(size);
		dto.setTelnum(telnum);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년도MM월dd일 HH시mm분ss초");
		Date now = new Date();
		String ordertime = sdf.format(now);
		
		dto.setOrdertime(ordertime);
		
		int result = pizzaService.orderPizza(dto);
		System.out.println(result);
		//피자 가격 계산
		//피자 객체 저장
		return dto;
	}
}
