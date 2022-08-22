package spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberMybatisController {
	@Autowired
	MemberService service;
	
	@RequestMapping("/membermybatislist")
	public ModelAndView memberlist() {
		List<MemberDTO> memberlist = service.memberlist();
		System.out.println(memberlist.size());
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist", memberlist);
		mv.setViewName("mybatis/memberlist");
		return mv;
	}
	
	@RequestMapping("/membermybatispaginglist")
	public ModelAndView memberlist
	(@RequestParam(value="page", required=false, defaultValue="1")  int page) {
		
		//총레코드수 몇개인지 알아오자
		int totalmember = service.getTotalMember();
		//현재페이지의 4개만 조회
		List<MemberDTO> memberlist = service.paginglist(new int[] {(page-1)*4, 4});

		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist", memberlist);
		mv.addObject("totalmember", totalmember);
		
		mv.setViewName("mybatis/memberpaginglist");
		return mv;
	}
	@RequestMapping("/membermybatissearchlist")
	public ModelAndView memberlist(String item, String searchword) {
		//item - 이름 검색 / 아이디 검색 ....
		MemberDTO dto = new MemberDTO();
		if(item.contains("이름")) {
			dto.setName(searchword); //name != null -- #{name}<=searchword
		}
		else if(item.contains("이메일")) {
			dto.setEmail(searchword);
		}
		else if(item.contains("폰번호")) {
			dto.setPhone(searchword);
		}
		else if(item.contains("아이디")) {
			dto.setId(searchword);
		}
		List<MemberDTO> memberlist = service.searchlist(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist", memberlist);
		mv.setViewName("mybatis/memberlist");//뷰 2개 컨트롤러 메소드 동시 설정
		return mv;
	}

}







