package annotation.memberservice;
//1개기능 - 최초구현 후 사용가능

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service2")
public class MemberService2 implements MemberService{

	@Autowired
	MemberDAO dao;
	//setter injection 용도
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	@Override
	public void registerMember() {
		if(dao.selectMember()== false) {
			
			dao.insertEmployee();
		}
	}
	
	
	@Override
	public String registerMember(MemberDTO dto) {
		if(dao.selectMember(dto)== false) {
			dao.insertMember(dto);
			return "회원가입 되셨습니다.";
		}else {
			return "회원가입실패(중복아이디)";
		}
		
	}

}
