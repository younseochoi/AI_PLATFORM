package chap5;

abstract class Shape {
	String name;
	abstract void area();//면적
	abstract void circum();//둘레
}
class Circle extends Shape{
	int radius;//반지름
	final double pi = 3.14;
	// 생성자 정의
	Circle(String name, int r){
		this.name = name;
		radius = r;
	}
	//area, circum 오버라이딩 
	void area() {
		System.out.println("반지름이 " + radius + " 인 " + name + " 의 면적= " + radius * radius * pi);
	}
	void circum() {
		System.out.println("반지름이 " + radius + " 인 " + name + " 의 둘레= " + 2 * radius * pi);
	}
}

class Rectangle extends Shape{
	int width;//가로
	int height;//세로
	// 생성자 정의
	Rectangle(String name, int w, int h){
		this.name = name;
		width = w;
		height = h;
	}
	// area, circum 오버라이딩
	void area() {
		System.out.println("가로 " + width + " 세로 " + height + " 인 " + name + " 의 면적= " + width*height);
	}
	void circum() {
		System.out.println("가로 " + width + " 세로 " + height + " 인 " + name + " 의 둘레= " + 2*(width+height) );	
	}
}
public class AbstractTest {

	public static void main(String[] args) {
		Circle c = new Circle("원", 5); //반지름 5인 원객체 생성
		Rectangle r = new Rectangle("사각형", 6, 8); //가로 6 세로 8 인 사각형객체 생성
		c.area();//반지름이 5인 원의 면적=xxxx.xx
		r.area();//가로 6 세로 8인 사각형의 면적=xxx
		c.circum();//반지름이 5인 원의 둘레=xxxx.xx
		r.circum();//가로 6 세로 8인 사각형의 둘레=xxx
	}

}
