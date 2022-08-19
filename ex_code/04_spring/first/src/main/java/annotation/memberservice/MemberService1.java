package annotation.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service1")
public class MemberService1 implements MemberService {
	@Autowired
	MemberDAO dao;
	
	@Override
	public void registerMember() {
	if(dao.selectMember() == false) {
		dao.insertMember();
		dao.insertEmployee();
	}
	else {
		System.out.println("회원가입할 수 없습니다(중복 아이디)");
	}
	}
	
	@Override
	public String registerMember(MemberDTO dto) {
	if(dao.selectMember(dto) == false) {
		dao.insertMember(dto);
		dao.insertEmployee(dto);
		return "회원가입되셨습니다. 신입사원으로도 등록하셨습니다.";
	}
	else {
		System.out.println("회원가입할 수 없습니다(중복 아이디)");
		return "회원가입할 수 없습니다(중복 아이디)";
	}
	}
}
