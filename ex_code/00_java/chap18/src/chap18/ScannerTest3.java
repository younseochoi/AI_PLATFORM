package chap18;

import java.text.DecimalFormat;
import java.util.Scanner;

class Employee{
	int id;
	String name;
	double pay;
	public Employee(int id, String name, double pay) {
		super();
		this.id = id;
		this.name = name;
		this.pay = pay;
	}
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###.00"); //6123.20 
		return  id + " 사번의 " + name + " 사원은 연봉은 " + df.format(pay*12) + " 입니다.";
	}
}
public class ScannerTest3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("사번 이름 월급여 순서로 입력하세요");
		// 100 이사원 665.88
		String line = scan.nextLine();
		//System.out.println(line);
		String[] word = line.split(" ");
		int id = Integer.parseInt(word[0]);
		String name = word[1];
		double pay = Double.parseDouble(word[2]);
		/*System.out.print("사원의 사번 : ");
		int id = scan.nextInt();
		System.out.print("사원의 이름 : ");
		String name = scan.next();
		System.out.print("사원의 월급여 : ");
		double  pay = scan.nextDouble();*/
		
		Employee e = new Employee(id, name, pay);
		System.out.println(e/*.toString()자동호출*/);
		/* 사원의 사번 : (출력)  100(키보드입력)
		 * 사원의 이름 : (출력)  이사원(키보드입력)
		 * 사원의 월급여 : (출력)  56000.88(키보드입력)  
		 * ===> Employee객체 생성하여 toString 호출하면 
		 * 100 사번의 이사원 사원은 연봉은  xxxx 입니다.
		 * */
		//
	}

}
