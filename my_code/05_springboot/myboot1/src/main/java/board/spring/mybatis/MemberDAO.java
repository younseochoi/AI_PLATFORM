package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("dao")
public interface MemberDAO {

	
	public List<MemberDTO> getList();
	public int getCount();
	public List<MemberDTO> oneMember(String id);
	
	public List<MemberDTO> paginglist(int[] limit);
	public int registerMember(MemberDTO dto);
	
	public int updateMember(MemberDTO dto);
	
	public int deleteMember(String id);
	
	public List<MemberDTO> searchMember(MemberDTO dto);
	

}
