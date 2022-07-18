package chap5;

class A /*extends java.lang.Object*/ {
	int i;
	A(String s){
		//super(); Object() 호출
		i = 100;
	}
}

class B extends A{
	int j;
	B(){
		super("전달");
		j = 200;
	}
}
public class ConstructorTest {

	public static void main(String[] args) {
		B b1 = new B();
		System.out.println(b1.i);
		System.out.println(b1.j);
	}
}
