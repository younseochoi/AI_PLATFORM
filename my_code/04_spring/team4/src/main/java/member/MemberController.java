package member;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MemberController {	
	@Autowired
	HttpSession session;
	
	@Autowired
	MemberService memserv;
	
	//회원가입
	@GetMapping("/registerform")
	public String registerform() {
		return "member/registerform";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute MemberDTO dto) {
		System.out.println(dto.getId());
		memserv.insertMember(dto);
		return "redirect:/loginform";
		
	}
	//로그인
	@GetMapping("/loginform")
	public String loginform() {
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(String id, String password, HttpServletRequest request) {
		List<MemberDTO> list = memserv.onemember(id);
		String model = "";
		if(list.size()== 0) {
			System.out.println("아이디 없음");
			return "member/login";
		}
		else {
			String dbpassword = list.get(0).getPw();
			System.out.println(dbpassword);
			if(dbpassword.equals(password)) {
				session.setAttribute("sessionid", id);
				System.out.println(session.getAttribute("sessionid"));
				model = "ok";
				return  "redirect:/";
				
			}
			else {
				System.out.println("비밀번호를 확인하세요");
				model = "fail";
				return  "redirect:/loginform";
			}
		}
	}
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		session = request.getSession();
		if(session.getAttribute("sessionid") != null) {
			session.removeAttribute("sessionid");
			System.out.println("로그아웃성공");
		}
		return "redirect:/";
	}
	
	
}