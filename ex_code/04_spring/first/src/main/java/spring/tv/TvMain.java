package spring.tv;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvMain {

	public static void main(String[] args) {
		// spring 라이브러리로부터 생성 객체 주입=전달(main 객체 생성-new x)
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring/tv/tv.xml");
		TV tv = (TV)factory.getBean("tv");

		tv.powerOn();
		tv.volumeUp(10);
		tv.volumeDown(5);
		tv.powerOff();
	}

}
//개발자 - 일부 코드 수정시에 같이 수정할 부분 많아진다면 힘들다 - 결합도 높다 - coupling 높다 
// 1> 삼성tv, 엘지tv 수정 부분 많다
// 2> TV 인터페이스 공통 메소드 정의 선언
// 3> TVFactory 도움받아서 원하는 객체 생성(main 객체생성-외부클래스 도움 객체 전달= DEPENDENCY INJECTION 
// 의존성 주입 
// 4> SPRING 3번 공장역할 
// 5> POJO 클래스 사용 - 스프링 프레임워크 개발 이전 미리 개발 완성 클래스들 --> 스프링 내부 사용
