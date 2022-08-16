package member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberScopeMain {
	public static void main(String args[]) {
		//1. 스프링 bean 2개 생성 부탁 - member/member.xml
		ApplicationContext factory = new ClassPathXmlApplicationContext("member/member.xml");
		
		MemberDTO dto1 = (MemberDTO)factory.getBean("dto1");//공유
		MemberDTO dto2 = (MemberDTO)factory.getBean("dto2");
		MemberDTO dto3 = (MemberDTO)factory.getBean("dto3");//????
		//MemberDTO dto4 = (MemberDTO)factory.getBean("dto1");//공유
		
		System.out.println(dto1); //패키지명.클래스명@16진수주소값
		System.out.println(dto2);
		System.out.println(dto3);
		//System.out.println(dto4);
		
	}
}
