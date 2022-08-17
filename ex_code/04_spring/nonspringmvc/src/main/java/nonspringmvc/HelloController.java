package nonspringmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

	@Override
	public String handleAndRequest(HttpServletRequest request, HttpServletResponse response) {
		//model 생성
		HelloDTO dto = new HelloDTO();
		//MODEL 값 저장
		dto.setMessage("컨트롤러가 jsp로 전달하는 모델입니다.");
		request.setAttribute("model", dto);
		//view 설정
		return "hello.jsp";
		
	}

}




