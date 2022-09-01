package member;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface MemberService {
	public List<MemberDTO> memberlist();
	public List<MemberDTO> onemember(String id);
	public int insertMember(MemberDTO dto);
	public ModelAndView memberDetail(String id);
	public ModelAndView modifyForm(String id);
	public ModelAndView updatemember(MemberDTO memberdto);
	public void deletemember(String memberId)throws Exception;
}
