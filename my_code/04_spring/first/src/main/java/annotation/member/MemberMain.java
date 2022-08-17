package annotation.member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		//1.spring 에게 bean 2개 생성 부탁 - member/member.xml
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/member/member.xml");
		
		//2.
		MemberDAO dao =(MemberDAO) factory.getBean("dao");
		//MemberDTO dto =(MemberDTO) factory.getBean("dto1"); //member.xml 정의 dto1 객체 생성
		//dao.setDto(dto);
		boolean result = dao.selectMember();
		if(result) {
			System.out.println(dao.dto.getId()+"정상 로그인 사용자입니다.");
		}else {
			dao.insertMember();
		}
		
		
	}

}
