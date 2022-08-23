package board.spring.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class MemberDAO {
	@Autowired
	SqlSession session;
	
	public List<MemberDTO> getList(){
		return session.selectList("member.memberlist");
	}
	
	public int getCount() {
		return session.selectOne("membercount");
	}
	
	public List<MemberDTO> oneMember(String id){//mybatis
		return session.selectList("onemember", id);
	}
	
	public List<MemberDTO> pagingList(int[] limit){
		return session.selectList("paginglist", limit);
	}
	
	public int insertMember(MemberDTO dto) {
		return session.insert("insertmember", dto);
	}
	
	public int updateMember(MemberDTO dto) {
		return session.update("updatemember", dto);
	}
	public int deleteMember(String id) {
		return session.delete("deletemember", id);
	}
	public List<MemberDTO> searchList(MemberDTO dto){
		return session.selectList("searchlist" , dto);
	}
}





