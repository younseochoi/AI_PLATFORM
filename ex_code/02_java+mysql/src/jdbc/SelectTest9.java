package jdbc;

import java.util.Scanner;

public class SelectTest9 {

	public static void main(String[] args) {
		SelectTest8 s = new SelectTest8();
		//키보드입력월 
		Scanner scan = new Scanner(System.in);
		System.out.println("제외할 월 : ");
		String month = scan.next();
		String output = s.test(month); //여러 main 클래스 호출 공유
		System.out.println(output);
	}

}
