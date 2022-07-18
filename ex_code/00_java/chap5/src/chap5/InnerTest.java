package chap5;
class Outer{// public 
	int i = 10; //멤버변수 유사 
	class Inner {//멤버이너클래스 
		int j = 20;
		void innermethod() {
			System.out.println(j+i);
		}
	}//class inner
	
	static class Inner2{//static멤버이너클래스
		int k = 30;
		void innermethod2() {
			System.out.println(k);//+i);
		}
	}

	void outermethod() {
		class Inner3 {//지역이너클래스
			int n = 40;
		}
		Inner3 i3=new Inner3(); 
	}
}


public class InnerTest {
	public static void main(String[] args) {
		Outer o = new Outer();
		System.out.println(o.i);
		//non-static member
		Outer.Inner oi = o.new Inner();
		System.out.println(oi.j);
		oi.innermethod();
		//static member
		Outer.Inner2 oi2 = new Outer.Inner2();
		System.out.println(oi2.k);
		oi2.innermethod2();//오류 static inner클래스에서 non-static 아우터변수 참조


	}

}
