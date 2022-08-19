package annotation.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service1")
public class MemberService1 implements MemberService{
	
	@Autowired
	MemberDAO dao ;
	
	//setter injection 용도 -- @Autowired 시 필요 없음. xml property로받을 때 필요했음.
	
//	public void setDao(MemberDAO dao) {
//		this.dao = dao;
//	}
	@Override
	public void registerMember() {
		if(dao.selectMember()== false) {
			dao.insertMember();
			dao.insertEmployee();
		}else {
			System.out.println("회원가입할 수 없습니다.");
		}
	}

	@Override
	public String registerMember(MemberDTO dto) {
		if(dao.selectMember(dto)== false) {
			dao.insertMember(dto);
			dao.insertEmployee(dto);
			return "회원가입 되셨습니다. 신입사원으로도 등록되셨습니다.";
		}else {
			return "회원가입실패(중복아이디)";
		}
		
	}
	
	

}
