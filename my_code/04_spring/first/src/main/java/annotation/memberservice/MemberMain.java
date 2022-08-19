package annotation.memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		//1.spring 에게 bean 2개 생성 부탁 - member/member.xml
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/memberservice/member.xml");
		
		//2.
		MemberService service = (MemberService) factory.getBean("service1");
		service.registerMember();
		
		
	}

}
