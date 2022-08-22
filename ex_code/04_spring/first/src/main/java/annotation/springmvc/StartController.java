package annotation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {
@RequestMapping("/")
public String start() {
	System.out.println("내가 시작컨트롤러입니다.");
	return "start";
}
}
