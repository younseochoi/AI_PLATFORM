package command;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommandMain {

	public static void main(String[] args) {
		//xxxCommand , command.xml 정의 객체 사용
		ApplicationContext factory = new ClassPathXmlApplicationContext("command/command.xml");
		Command c1 =factory.getBean(BoardCommand.class, "board");
		Command c2 =factory.getBean(MemberCommand.class, "member");
		Command c3 =factory.getBean(ProductCommand.class, "product");
		
		c1.run();
		c2.run();
		c3.run();
		
		//Command c1 = (BoardCommand)factory.getBean("board");
	}

}
