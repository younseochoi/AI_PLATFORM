package member;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MypageController {
	@Autowired
	HttpSession session;
	
	@Autowired
	MemberService memserv;
	
	ModelAndView mav = new ModelAndView();
	
	//회원정보
		@RequestMapping(value = "/memberDetail", method = RequestMethod.GET)
		public ModelAndView memberDetail(HttpServletRequest request) {
			session = request.getSession();
			String id = (String)session.getAttribute("sessionid");
			mav = new ModelAndView();
			mav = memserv.memberDetail(id);
			return mav;
		}
		
		//회원정보 수정
		@RequestMapping(value = "/modifyForm", method = RequestMethod.GET)
		public ModelAndView modifyForm(@RequestParam String id) {
			System.out.println("넘어온 아이디 " + id);
			mav = new ModelAndView();
			mav = memserv.modifyForm(id);
			return mav;
		}
		
		@RequestMapping(value = "/memberModify", method = RequestMethod.POST)
		public ModelAndView memberModify(@ModelAttribute MemberDTO memberdto) {
			mav = new ModelAndView();
			System.out.println("수정폼 ");		
			mav = memserv.updatemember(memberdto);
			return mav;
		}

		
		//회원 탈퇴
		@RequestMapping(value="/delete", method=RequestMethod.GET)
		public ModelAndView delete(@RequestParam String id) {
			mav = new ModelAndView();
			System.out.println("delete() 메소드 호출");
			mav.addObject("id",id);
			mav.setViewName("mypage/delete");
			return mav;
		}
		
		@PostMapping(value="/deletemember")
		public String deletemember(String id,String pw,HttpServletRequest request) throws Exception{
			session = request.getSession();
			id = (String)session.getAttribute("sessionid");
			List<MemberDTO> list = memserv.onemember(id);		
			if(list.size()== 0) {
				System.out.println("아이디 없음");
				return "/mypage/delete";
			}
			else {
				String dbpassword = list.get(0).getPw();
				if(dbpassword.equals(pw)) {
					System.out.println("탈퇴 - 완료");
					memserv.deletemember(id);
					session.invalidate();
					return  "member/login";				
				}
				System.out.println("비밀번호를 확인하세요");
				return  "mypage/delete";
			}

		}

}
