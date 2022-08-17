package annotation.memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberBeanNameMain {
	
	public static void main(String args[]) {
		//1. 스프링 bean 2개 생성 부탁 - member/member.xml
		ApplicationContext factory = new ClassPathXmlApplicationContext
				("annotation/memberservice/member.xml");
		String[] names = factory.getBeanDefinitionNames();
		for( String name : names) {
			System.out.println(name);
		}
		
		
	}
}


//main --> service-registerMember() --> dao(1,2,3...), dto