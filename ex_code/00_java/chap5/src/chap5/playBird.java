package chap5;

class Bird{
	//공통
	String name;
	int  legs = 2;
	double length;

	void fly() { System.out.println("Bird:fly");} 
	void sing() {
		System.out.println(name + " 소리내어 웁니다");
	}
	void setName() {System.out.println("Bird:setname");}
	void print() {System.out.println("Bird:print");}
}
class Duck extends Bird{
	String color;
	void swim() {
		System.out.println
		(name + "가 " + color + "의 물갈퀴로 수영합니다.");
	}
	@Override
	void fly() {
		System.out.println(name + "는 날지 않습니다. ");
	}
	@Override
	void print() {
		System.out.println
		("오리의 이름은 " + name + " 입니다.");
	}
	
}
class Sparrow extends Bird{
	String friend;
	void makeFriend() {
		System.out.println
		("참새의 친구는 " +  friend + "입니다.");
	}
	void fly() {
		 System.out.println(name + "가 날아다닙니다.");
	}
	
	@Override
	void print() {
		System.out.println("참새의 이름은 " + name + " 입니다.");
	}
	
	
}

class PlayBird {
public static void main(String args[] ){
	Duck d = new Duck();
	d.name = "오리(꽥꽥이)";//상속
	d.color = "갈색";
	//d.legs = 2;//상속
	d.length = 20.2;//상속
	
	d.fly();//상속 오버라이딩
	d.sing();//상속 그대로-참새
	d.swim();//Duck 메소드
	d.print();//상속 오버라이딩
	
	Sparrow s = new Sparrow();
	s.name = "참새(짹짹이)";
	s.friend = "허수아비";
	//s.legs = 2;
	s.length = 10.5;
	
	s.fly();
	s.sing();
	s.makeFriend();
	s.print();
}
}


