package board.spring.mybatis;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MemberController {

	@Autowired
	@Qualifier("memberservice")
	MemberService service;
	
	@GetMapping("/boardlogin")
	public String loginform() {
		return "board/loginform";
	}
	
	@PostMapping("/boardlogin")
	public String loginProcess(String id, int password, HttpServletRequest request ) {
		HttpSession session = request.getSession();
		List<MemberDTO> list= service.oneMember(id);
		if(list.size() == 0) {
			//회원가입 안되어있다.
			System.out.println("로그인 실패");
		}else {
			System.out.println(list.get(0).toString());
			int dbpassword =list.get(0).getPassword();
			if(password == dbpassword) {
				
				session.setAttribute("sessionid", id);
				System.out.println("로그인 성공"+dbpassword+"::"+password);
			}
		}
		return "board/start";
	}
	
	@GetMapping("/boardlogout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionid") !=null) {
			session.removeAttribute("sessionid");
		}
		return "board/start";
	}
	
}
