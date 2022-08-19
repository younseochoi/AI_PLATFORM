package mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MemberDAO {
	
	SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
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
}
