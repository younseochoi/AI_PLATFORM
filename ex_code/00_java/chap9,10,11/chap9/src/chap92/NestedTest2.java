package chap92;


class A {
	interface I{
		void m1();
		void m2();
	}
	//I i1 = new I(); //인터페이스 객체 생성 불가능
	
	//익명 객체 생성 
	I i1 = new I() {
		public void m1() {System.out.println("m1");}
		public void m2() {System.out.println("m2");}
	};// 인터페이스 I 상속 익명(ANONYMOUS) 클래스 정의 동시에 객체 생성. 안드로이드앱 
 
   //static / 지역변수  / 외부클래스 변수들 내부 인터페이스 사용 가능 
}


public class NestedTest2 {

	public static void main(String[] args) {
		A a1 = new A();
		a1.i1.m2();
		a1.i1.m1();

	}

}
