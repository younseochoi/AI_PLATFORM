package nonspringmvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListController implements Controller {

	@Override
	public String handleAndRequest(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<HelloDTO> list = new ArrayList();
		for(int i = 1; i <=5; i++) {
			HelloDTO dto = new HelloDTO();
			dto.setMessage("리스트" + i);
			list.add(dto);
		}
		request.setAttribute("list", list);
		return "list.jsp";
	}

}
