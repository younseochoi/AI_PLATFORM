package mysqljd;

import java.util.Scanner;

public class SelectTest9 {

	public static void main(String[] args) {
		SelectTest8 s = new SelectTest8();
		//키보드입력 월은 여기서 매개변수로 전달 

		Scanner sc = new Scanner(System.in);
		System.out.print("제외할 월 : ");
		String input = sc.next();
		s.test(input); //여러메인 클래스 호출 공유 
	}

}
