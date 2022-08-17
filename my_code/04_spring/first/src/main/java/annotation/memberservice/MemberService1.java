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
		}
	}

}
