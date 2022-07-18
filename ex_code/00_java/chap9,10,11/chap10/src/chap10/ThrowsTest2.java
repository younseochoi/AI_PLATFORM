package chap10;

import java.io.FileNotFoundException;
import java.io.FileReader;

class A {
	void m1(int i) throws FileNotFoundException {
		System.out.println(100/i);
		FileReader fr = new FileReader("b.txt");
	}
	void m2() throws FileNotFoundException{
		m1(0);
	}
}
public class ThrowsTest2 {
//자바실행툴=자바인터프리터 기본 예외처리 기능 내장 = e.printStackTrace() 호출 동일 
	public static void main(String[] args) throws FileNotFoundException{
		A a1 = new A();
		a1.m2();
	}
}
