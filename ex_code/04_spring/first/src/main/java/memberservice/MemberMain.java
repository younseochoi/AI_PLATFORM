package memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {
	public static void main(String args[]) {
		//1. 스프링 bean 2개 생성 부탁 - member/member.xml
		ApplicationContext factory = new ClassPathXmlApplicationContext("memberservice/member.xml");
		MemberService service = (MemberService)factory.getBean("service");
		service.registerMember();//회원가입기능
		
	}
}


//main --> service-registerMember() --> dao(1,2,3...), dto