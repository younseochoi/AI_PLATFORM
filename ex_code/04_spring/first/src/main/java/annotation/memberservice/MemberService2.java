package annotation.memberservice;
//1개기능= 최초구현 이후에 변경 가능

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service2")
public class MemberService2 implements MemberService {
	@Autowired
	MemberDAO dao;
	//setter injection 용도
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void registerMember() {
	if(dao.selectMember() == false) {
		dao.insertMember();
	}
	
}

	@Override
	public String registerMember(MemberDTO dto) {
	if(dao.selectMember(dto) == false) {
		dao.insertMember(dto);
		return "회원가입되셨습니다. ";
	}
	else {
		System.out.println("회원가입할 수 없습니다(중복 아이디)");
		return "회원가입할 수 없습니다(중복 아이디)";
	}
	}
}
