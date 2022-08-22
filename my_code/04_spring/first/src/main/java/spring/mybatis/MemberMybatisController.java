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
//		item=이메일+검색&searchword=sfdsdss
		List<MemberDTO> memberlist = service.memberlist();
		System.out.println(memberlist.get(0));
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist", memberlist);
		mv.setViewName("mybatis/memberlist");
		return mv;
	}
	
	@RequestMapping("/membermybatispaginglist")
	public ModelAndView memberlist(@RequestParam(value = "page", required = false) int page) {
		//총 레코드 수 몇개인지 알아와서 페이지 번호 생성하기
		int totalmember = service.getTotalMember();
		ModelAndView mv = new ModelAndView();

		List<MemberDTO> memberlist = service.paginglist(new int[] {(page-1)*4,4});
		
		mv.addObject("totalmember",totalmember);
		mv.addObject("memberlist", memberlist);
		mv.setViewName("mybatis/memberpaginglist");
		return mv;
	}
	
//	MemberMybatisController
//	1> 메소드
//	url 매핑 - /membermybatissearchlist
//	            item/searchword 파라미터로 전송
//	조건 맞는 데이터만 검색
//	memberlist.jsp 결과 리턴 
//
//	MemberService / MemberServiceImpl/MemberDAO
//	2>
//	sql-mapping.xml 
//	select * from member where ????? like '%' || #{searchword} || '%'
//	<choose> 880p 참고 
//	<when> 

	@RequestMapping("/membermybatissearchlist")
	public ModelAndView searchmemberlist(@RequestParam(value = "item", required = false, defaultValue = "name")String item, @RequestParam(value="searchword" , required = true) String searchword) {
		ModelAndView mv = new ModelAndView();
		MemberDTO dto = new MemberDTO();
		if(item.equals("name")) {
			dto.setName(searchword);
		}else if(item.equals("id")) {
			System.out.println(item);
			dto.setId(searchword);
			System.out.println(dto.getId());
		}else if(item.equals("email")) {
			dto.setEmail(searchword);
		}else if(item.equals("phone")) {
			dto.setPhone(searchword);
		}
		List<MemberDTO> memberlist = service.searchMember(dto);
		mv.addObject("memberlist", memberlist);
		mv.setViewName("mybatis/memberlist");
		return mv;
	}
	
}
