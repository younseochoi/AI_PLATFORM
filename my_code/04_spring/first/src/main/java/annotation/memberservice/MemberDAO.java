package annotation.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository("dao")
public class MemberDAO {
	@Qualifier("dto2")
	@Autowired
	MemberDTO dto;
//	1.Autowired 클래스타입 객체이면 자동전달
//	2. Qulifier 없고 여러개면 dto 라는 객체 자동 전달
//	3. Qualifier 있으면 설정 이름의 객체 자동 전달
	
	
//	public void setDto(MemberDTO dto) { //외부로부터 dto 객체 전달받기 위함
//		this.dto = dto;
//	}
	public boolean selectMember() {
		if(dto.getId().equals("spring")&&dto.getPassword() == 1111) {
			return true; //정상적인 로그인 
		}
		return false;
	}
	public void insertMember() {
		System.out.println(dto.getId()+"회원님 정상적으로 회원가입되셨습니다.");
	}
	
	public void insertEmployee() {
		System.out.println(dto.getId()+" 신입사원으로 입사하셨습니다.");
	}
}
