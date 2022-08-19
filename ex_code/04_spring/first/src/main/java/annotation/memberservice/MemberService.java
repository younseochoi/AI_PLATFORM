package annotation.memberservice;

public interface MemberService {
	public void registerMember();//main .member.xml 생성값 
	
	public String registerMember(MemberDTO dto);//컨트롤러<-요청파라미터값
}
