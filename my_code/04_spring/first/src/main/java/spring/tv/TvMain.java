package spring.tv;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring/tv/tv.xml");
		
		//tv 주문하면 공장 생산 - 제공
		TV tv = (TV)  factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp(10);
		tv.volumeDown(5);
		tv.powerOff();
//		
//		tv = factory.getTV("엘지");
//		tv.powerOn();
//		tv.volumeUp(10);
//		tv.volumeDown(5);
//		tv.powerOff();
		
	}

}
//개발자 - 일부 코드 수정시에 같이 수정할 부분 많아지면 힘들다. - 결합도 높다 - coupling 높다