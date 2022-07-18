package chap10;

class B{
	void m1(int i) {
		if(i == -1) {
			throw new ArithmeticException("음수 나누기 불가");
		}
		else {
			System.out.println(100 / i);
		}
	}
}
public class ThrowTest {

	public static void main(String[] args) {
		B b1 = new B();
		try {
			b1.m1(-1);
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}

	}

}
