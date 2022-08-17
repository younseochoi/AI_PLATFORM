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

}
