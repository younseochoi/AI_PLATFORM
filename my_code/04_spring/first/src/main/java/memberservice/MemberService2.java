package memberservice;
//1개기능 - 최초구현 후 사용가능
public class MemberService2 implements MemberService{

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
	

}
