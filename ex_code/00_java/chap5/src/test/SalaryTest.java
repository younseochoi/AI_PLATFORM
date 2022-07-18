package test;

class Employee {
 	int id;
 	String name;
 	int basePay;//본봉
 	int generalFee;//일반수당
 	int totalPay;//총급여
  	
 	Employee(int id, String name, int basePay, int genralFee){
 		this.id = id;
 		this.name = name;
 		this.basePay = basePay;
 		this.generalFee = genralFee;
 	}

 	public void calcPay() {
 		totalPay = basePay + generalFee;
 	}
}

class Manager extends Employee{
	int manFee;
	Manager(int id, String name, int basePay, int generalFee, int manFee){
		super(id, name, basePay, generalFee);//명시정의  Employee(int, String, int, int)생성자호출
		this.manFee = manFee;
	}
	public void calcPay() {
		super.calcPay();
		totalPay += manFee;
	}
}

class Engineer extends Employee {
	int certiFee, techFee;

	public Engineer(int id, String name, int basePay, int genralFee, int certiFee, int techFee) {
		super(id, name, basePay, genralFee);
		this.certiFee = certiFee;
		this.techFee = techFee;
	}
	
	@Override
	public void calcPay() {
		super.calcPay();
		totalPay += certiFee + techFee;
	}
		
}
 	
 
		
class Secretary extends Employee {
	int secFee;
	
	public Secretary(int id, String name, int basePay, int genralFee, int secFee) {
		super(id, name, basePay, genralFee);
		this.secFee = secFee;
	}
	@Override
	public void calcPay() {
		super.calcPay();
		totalPay += secFee;
	}

}
//====== 4개 클래스 정의 ================
	   
class SalaryTest{
public static void main(String args[]){

	Employee e [] = new Employee[4];
	// 1.상속 2.생성자(타입 순서 갯수....)
	e[0] = new Employee(1000,"이사원",10000,5000);
	e[1] = new Manager(2000,"김간부",20000,10000,10000);
	e[2] = new Engineer(3000,"박기술",15000,7500,5000,5000);
	e[3] = new Secretary(4000,"최비서",15000,7000,10000);
	//자동형변환 이후에 변수 접근 - 상위클래스 포함 변수
	//System.out.println( ((Manager)e[1]).manFee  );
	
	/* 배열 내의 각 객체의 
          급여계산메소드 호출하고
	사번, 이름, 총급여 출력

사번:이름:본봉:총급여
1000:이사원:10000:xxxxx
2000:김간부:20000:xxxxx
3000:박기술:15000:xxxxx
4000:최비서:15000:xxxxx
 */ 
	System.out.println("사번:이름:본봉:총급여");
	for(int i = 0; i < e.length; i++) {
		e[i].calcPay();
		System.out.println(e[i].id +":" + e[i].name + ":" + e[i].totalPay);
		// e배열 Sectary객체이면 secFee 변수도 출력. instance = 객체
		if(e[i] instanceof Manager) { // i=0,1,2(false) i=3(true)
			System.out.println( i + "번째 객체=" +  ((Manager)e[i]).manFee    );
		}//if
	}//for
	}//main
}//class
