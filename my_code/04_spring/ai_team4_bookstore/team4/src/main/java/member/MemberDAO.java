package member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	SqlSession session;
	
	@Autowired
	MemberService memserv;
	
	public List<MemberDTO> getList(){
		return session.selectList("memberlist");
	}
	
	public List<MemberDTO> oneMember(String id){
		return session.selectList("onemember", id);
	}
	
	public int insertMember(MemberDTO dto) {
		return session.insert("insertmember", dto);
	}

	public int deletemember(String id) {
		return session.delete("deletemember", id);
	}
	
	public int updatemember(MemberDTO memberdto) {
		return session.update("updatemember", memberdto);
	}
	
	public MemberDTO memberDetail(String id) {
		return session.selectOne("memberDetail", id);
	}
	
	public MemberDTO memberPassword(String id) {
		return session.selectOne("memberPassword", id);
	}
	
	
	
}
