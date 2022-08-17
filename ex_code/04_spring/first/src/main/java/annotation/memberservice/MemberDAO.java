package annotation.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class MemberDAO {
	@Qualifier("dto2") //id=jsp
	@Autowired
	MemberDTO dto;
	/* 1. Autowired 클래스타입 객체이면 자동 전달
	 * 2. Qualifier 없고 여러개이면 dto 라는 객체 자동 전달
	 * 3. Qualifier 있으면 설정 이름의 객체 자동 전달 */
	
	public boolean selectMember() {
		if(dto.getId().equals("spring") && dto.getPassword() == 1111) {
			return true;// 정상 로그인 사용자 경우 리턴값
		}
		else {
			return false;//회원가입 경우 리턴값
		}
	}
	public void insertMember() {
		System.out.println(dto.getId() + " 회원님 정상적으로 회원가입되셨습니다.");
	}
	public void insertEmployee() {
		System.out.println(dto.getId() + " 신입사원으로 입사하셨습니다.");
	}
}
