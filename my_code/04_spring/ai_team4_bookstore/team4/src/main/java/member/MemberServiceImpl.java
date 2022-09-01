package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDAO dao;
	
	
	
	@Override
	public List<MemberDTO> memberlist() {
		List<MemberDTO> list = dao.getList();
		return list;
	}

	@Override
	public List<MemberDTO> onemember(String id) {
		return dao.oneMember(id);
	}

	@Override
	public int insertMember(MemberDTO dto) {
		List<MemberDTO> list = dao.oneMember(dto.getId());
		if(list == null || list.size() == 0) {
			return dao.insertMember(dto);
		}
		else {
			return 0;
		}
	}
	//회원 정보
	public ModelAndView memberDetail(String id) {
		ModelAndView mav = new ModelAndView();
		MemberDTO memberdto = dao.memberDetail(id);
		System.out.println("정보실행");
		mav.addObject("mypage", memberdto);
		mav.setViewName("mypage/mypage");
		return mav;
	}
	//회원 정보 수정
	public ModelAndView modifyForm(String id) {
		ModelAndView mav = new ModelAndView();
		MemberDTO memberdto = dao.memberDetail(id);
		mav.addObject("modify", memberdto);
		mav.setViewName("mypage/modify");
		return mav;
	}
	
	public ModelAndView updatemember(MemberDTO memberdto) {
		ModelAndView mav = new ModelAndView();
		MemberDTO inputmember = memberdto;
		int result = dao.updatemember(inputmember);
		if (result != 0) {
			MemberDTO member = dao.memberDetail(inputmember.getId());
			mav.addObject("mypage", member);
			mav.setViewName("mypage/mypage");
		} else {
			mav.setViewName("main/index");
		}
		return mav;

	}

	public void deletemember(String id)throws Exception{
		dao.deletemember(id);
	}
}