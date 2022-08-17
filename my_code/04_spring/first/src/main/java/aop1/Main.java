package aop1;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext factory= new ClassPathXmlApplicationContext("aop1/aop1.xml");
		Member member = factory.getBean(Member.class,"member");
		Board board= factory.getBean(Board.class,"board");
		member.login("aop");
		board.insert(100);
		ArrayList<String> list = board.getList();
		for(String s:list) {
			System.out.println(s);
		}
		member.logout();
	}

}
