package chap5;

public interface Student {
	/*public final static 자동정의*/String name = "학생";
	/*abstract public 자동정의*/void study();
	void lunch();
	//오버라이딩 규칙 - 하위클래스 modifier 같거나 더 넓어야 한다
	// 인터페이스 상속 구현 클래스 메소드 오버라이딩 public 
	
	
}
