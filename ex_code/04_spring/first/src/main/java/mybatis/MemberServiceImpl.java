package mybatis;

import java.util.List;

public class MemberServiceImpl implements MemberService{
	
	MemberDAO dao;
	
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<MemberDTO> memberlist() {
		List<MemberDTO> list = dao.getList();
		int count = dao.getCount();
		
		list.add(new MemberDTO(null, count, null, null, null, null));
		
		return list; //main 결과 리턴 - 갯수 마지막 객체 암호 포함 
	}

	@Override
	public List<MemberDTO> onemember(String id) {
		return dao.oneMember(id);
	}

	@Override
	public List<MemberDTO> paginglist(int[] limit) {
		return dao.pagingList(limit);
	}
	
	
	
	
	
}
