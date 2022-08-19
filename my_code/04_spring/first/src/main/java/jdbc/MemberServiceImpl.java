package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO dao = new MemberDAO();
	
	@Override
	public String registermember(MemberDTO dto) {

		int result = dao.selectMember(dto.getId(), String.valueOf(dto.getPassword()));
		if(result == 3) {
			dao.insertMember(dto);
			return "회원가입 완료, 가입 성공!!";
		}else {
			return "회원 중복 아이디";
		}
	}

}
