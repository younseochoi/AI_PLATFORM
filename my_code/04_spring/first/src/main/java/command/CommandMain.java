package command;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommandMain {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("command/command.xml");
		MemberCommand member = (MemberCommand) factory.getBean("member");
		BoardCommand board = (BoardCommand) factory.getBean("board");
		ProductCommand product= (ProductCommand) factory.getBean("product") ;
		board.run();
		member.run();
		product.run();
		
		Command c1 = factory.getBean(MemberCommand.class,"member");
		Command c2 = factory.getBean(BoardCommand.class,"board");
		Command c3 = factory.getBean(ProductCommand.class,"product");
		
		c1.run();
		c2.run();
		c3.run();
	}

}
