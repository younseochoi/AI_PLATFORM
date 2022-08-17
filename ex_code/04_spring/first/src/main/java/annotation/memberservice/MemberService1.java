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
	
	}
	
}
