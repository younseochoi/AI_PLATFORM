package chap5;

class Employee {//회사원
	int id;
	String name = "회사원";//Employee.name
	double pay;
	void printInform() {
		System.out.println(id +":"+name+":"+pay);
		//50문장 정의
	}
}

class Manager extends Employee{//관리직
	String name = "관리직";//Manager.name
	String jobOfManage ;
	//Employee 없다가 Manager 추가
	void test() {
		String name = "지역변수"; 
		System.out.println(name);//지역변수
		System.out.println(this.name);//현재멤버변수
		System.out.println(super.name);//상속멤버변수
	}
	@Override
	void printInform() {
		//System.out.println(id +":"+name+":"+pay);
		super.printInform();//50문장 수행 호출
		System.out.println(jobOfManage);
	}
}
public class ManagerTest {

	public static void main(String[] args) {
		Manager m = new Manager();
		m.id = 200;
		//m.name = "홍길동";
		m.pay = 34500.99;
		m.jobOfManage = "it관리";
		System.out.println("사번=" + m.id);//Employee 상속
		System.out.println("이름=" + m.name);//관리직
		System.out.println("급여=" + m.pay);
		System.out.println("관리업무=" + m.jobOfManage);//Manager 선언
		m.printInform();//Manager 재정의 메소드 실행
		m.test();//3줄
	}
}
