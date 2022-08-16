package member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {
	public static void main(String args[]) {
		//1. 스프링 bean 2개 생성 부탁 - member/member.xml
		ApplicationContext factory = new ClassPathXmlApplicationContext("member/member.xml");
		
		MemberDAO dao = (MemberDAO)factory.getBean("dao");

		boolean result = dao.selectMember();  
		if(result == true){
			System.out.println(dao.dto.getId() + " 님 정상 로그인 사용자입니다.");
		}
		else {
			dao.insertMember();
		}
	}
}
