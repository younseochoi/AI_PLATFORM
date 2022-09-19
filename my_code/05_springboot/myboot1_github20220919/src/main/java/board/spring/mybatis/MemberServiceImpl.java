package board.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberservice")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO dao;
	
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
	
	//회원정보 수정
	@Override
	public int updateMember(MemberDTO dto) {
		List<MemberDTO> list = dao.oneMember(dto.getId());
		if(list.size()>0) {
			return dao.updateMember(dto);
		}else {
			return 0;
		}
	}
	
	@Override
	public int deleteMember(String id) {
		return dao.deleteMember(id);
	}

	//전체 회원수 
	@Override
	public int getTotalMember() {
		return dao.getCount();
	}

	//검색 
	@Override
	public List<MemberDTO> searchMember(MemberDTO dto) {
		return dao.searchMember(dto);
	}
	
	
	
	
	
	
	
	
}
