package nonspringmvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class ListController implements Controller {

	@Override
	public String handleAndRequest(HttpServletRequest request, HttpServletRequest response) {
		ArrayList<HelloDTO> list = new ArrayList<HelloDTO>();
		for(int i=0;i<5;i++) {
			list.add(new HelloDTO());
			list.get(i).setMessage((i+1)+"번째 HelloDTO 객체입니다.");
		}
//		for(int i=0;i<5;i++) {
//			list.get(i).setMessage((i+1)+"번째 HelloDTO 객체입니다.");
//		}
		request.setAttribute("list", list);
		return "list.jsp";
	}

}
