package chap9;
class A{
	int v = 10;
	B b1 = new B();//중첩 클래스 객체 생성 위치 A 내부 
	class B{
		int x = 20;
		void bmethod() {
			System.out.println(x);
			System.out.println("v="+v);
			//외부클래스 선언 멤버변수 사용 가능
			//jdk 1.7 버전까지는 외부클래스 final 변수만 내부클래스 사용 가능
			//jdk 1.8 버전부터는 외부클래스  변수만 내부클래스 사용 가능
		}
	}
	static class C{
		int y = 30;
		void cmethod() {
			System.out.println(y);
		}
	}
	void amethod() {
		B b2 = new B();//중첩 클래스 타입 객체 지역변수
		System.out.println(b2.x);
		//System.out.println(x);
	}
}
public class NestedTest {
	public static void main(String[] args) {
		//지역변수
		A a2 = new A();
		a2.amethod();
		
		
	// non-static 멤버변수
	A a1 = new A();
	 System.out.println(a1.b1.x);
	 a1.b1.bmethod();
	 
	 A.B b2 = new A().new B();
	 System.out.println(b2.x);
	 b2.bmethod();
	 
	 //static 멤버변수
	 A.C c2 = new A.C();
	 System.out.println(c2.y);
	 c2.cmethod();
	}

}
