package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("dao")
public class MemberDAO {
	@Autowired
	SqlSession session;
//	
//	public void setSession(SqlSession session) {
//		this.session = session;
//	}
//	
	public List<MemberDTO> getList(){
		return session.selectList("member.memberlist"); //namespace.id
	}
	public int getCount(){
		return session.selectOne("membercount");
	}
	
	public List<MemberDTO> oneMember(String id){
		return session.selectList("onemember",id);
	}
	
	public List<MemberDTO> paginglist(int[] limit){
		return session.selectList("paginglist",limit);
	}
	
	public int registerMember(MemberDTO dto) {
		System.out.println(dto);
		return session.insert("insertmember",dto);
	}
	
	public int updateMember(MemberDTO dto) {
		return session.update("updatemember",dto);
	}
	
	public int deleteMember(String id) {
		return session.delete("deletemember",id);
	}
	
	public List<MemberDTO> searchMember(MemberDTO dto){
		System.out.println(session.selectList("searchmember",dto));
		return session.selectList("searchmember",dto);
	}
	

}
