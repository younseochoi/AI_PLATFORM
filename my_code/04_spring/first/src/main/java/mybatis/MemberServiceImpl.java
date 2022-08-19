package mybatis;

import java.util.List;


public class MemberServiceImpl implements MemberService {
	
	MemberDAO dao;
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	@Override
	public List<MemberDTO> memberlist() {
		
		List<MemberDTO> list =  dao.getList();
		int count = dao.getCount();
		list.add(new MemberDTO(null, count, null, null, null, null ));
		return list; // 개수는 마지막 데이터의 암호에 저장
	}
	
	@Override
	public List<MemberDTO> oneMember(String id) {
		return dao.oneMember(id);
	}
	@Override
	public List<MemberDTO> paginglist(int[] limit) {
		return dao.paginglist(limit);
	}
	@Override
	public int registerMember(MemberDTO dto) {
		 List<MemberDTO> list = dao.oneMember(dto.getId());
		 if( list == null || list.size() == 0) {
			 return dao.registerMember(dto);
		 }else {
			 return -1;
		 }
	}

	
	
	
	
	
}
