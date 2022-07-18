package chap5;
/*interface I{
	void m1();
	void m2();
}
class A implements I{
	@Override
	public void m1() {
		// TODO Auto-generated method stub
	}
	@Override
	public void m2() {
		// TODO Auto-generated method stub
	}
}
*/
class A2 {
	interface I{
		void m1();
		void m2();
	}

	I i2 = new I() {
		public void m1() {System.out.println("I인터페이스 m1");}
		public void m2() {System.out.println("I인터페이스 m2");}
	};
	
	/*void ma() {
		I i2 = new I() {
			public void m1() {System.out.println("I인터페이스 m1");}
			public void m2() {System.out.println("I인터페이스 m2");}
		};
	}*/
}
public class InnerTest2 {

	public static void main(String[] args) {
		A2 a2 = new A2();
		a2.i2.m1();
		a2.i2.m2();
	}

}
