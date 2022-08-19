package annotation.memberservice;

public interface MemberService {
	void registerMember(); //main . member.xml 생성값
	String registerMember(MemberDTO dto); //컨트롤러 <- 사용자 요청 파라미터 메소드 오버로드
	
}
