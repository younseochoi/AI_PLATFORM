package mybatis;

import java.util.List;

public interface MemberService {
	public List<MemberDTO> memberlist();
	public List<MemberDTO> onemember(String id);
	public List<MemberDTO> paginglist(int[] limit);
}
