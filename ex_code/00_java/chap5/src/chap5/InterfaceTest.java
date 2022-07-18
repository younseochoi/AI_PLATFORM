package chap5;
//super - 상위클래스 타입 "객체" 의미 키워드
// 인터페이스 객체 생성 불가능
class StudentWorker implements Student,Worker {//조교(학생+교직원 이다)
	//인터페이스의 하위클래스 = 인터페이스를 구현하는 클래스
	//String name="학생" 자동포함
	//String name = "교직원"; 자동포함
	String name = "조교";
	public void study() {
		//오류 Student.name = "대학원생";
		System.out.println(name);//조교
		//오류 System.out.println(super.name);
		System.out.println(Student.name);//학생
		System.out.println(Worker.name);//교직원
		System.out.println("조교는 오전에 공부하다");
	}
	public void work() {
		System.out.println("조교는 오후에 행정업무하다");
	}
	public void lunch() {
		System.out.println("조교는 점심먹다");
	}

}


public class InterfaceTest {
	public static void main(String[] args) {
	StudentWorker sw = new StudentWorker();
	sw.study();
	sw.lunch();
	sw.work();
	// 상위인터페이스명 변수명1 = new 하위클래스객체
	// 변수명1.오버라이딩메소드==>Student 인터페이스 포함 메소드를 StudentWorker 오버라이딩한 메소드들 
	// 변수명1.변수==>Student
	Student sw2 = new StudentWorker();
	sw2.study();
	sw2.lunch();
	//오류sw.work();
	Worker sw3 = new StudentWorker();
	//오류sw3.study();
	sw3.lunch();
	sw3.work();
}
}






