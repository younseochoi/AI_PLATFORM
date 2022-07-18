package chap5;

class Parent{
	int su = 10;
	void pr() {
		System.out.println(su);//10
	}
	void pmethod() {
		System.out.println("Parent클래스");
	}
}
class Child1 extends Parent{
	int su = 20;
	void pr() {
		System.out.println(su);//20 오버라이딩
	}
	void cmethod() {
		System.out.println("Child1클래스");
	}
}
public class CastingTest {
	public static void main(String[] args) {
		Parent p = new Parent();//형변환필요x
		System.out.println(p.su);
		p.pr();
		p.pmethod();
		//p.cmethod();//메모리 존재x
		
		Child1 c1 = new Child1();//형변환필요x
		System.out.println(c1.su);
		c1.pr();
		c1.pmethod();
		c1.cmethod();//ok
		
		Parent p2 = new Child1();//자동형변환
		System.out.println(p2.su);//상위클래스 포함 변수
		p2.pr();//오버라이딩메소드 하위클래스 포함
		p2.pmethod();
		//p2.cmethod();//오류. 메모리 존재o. 하위클래스객체영역 포함 
		
		/*Child1 c2 = (Child1)p2; //명시적형변환 (용도 - 원래 하위객체 포함 변수나 메소드 사용)
		c2.cmethod();
		*/
		((Child1)p2).cmethod();
		
		
	}

}





