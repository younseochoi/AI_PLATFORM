package nonspringmvc;

import javax.servlet.http.HttpServletRequest;

public class HelloController implements Controller {

	@Override
	public String handleAndRequest(HttpServletRequest request, HttpServletRequest response) {
		//모델 생성
		HelloDTO dto = new HelloDTO();
		//model 값 저장 
		dto.setMessage("컨트롤러가 jsp로 전달하는 모델입니다.");
		request.setAttribute("model", dto);
		return "hello.jsp";
	}

}
