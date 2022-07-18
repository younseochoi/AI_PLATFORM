package chap18;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		
	/*	Scanner scan = new Scanner(System.in);
		System.out.println("2개의 정수를 입력하면 덧셈 결과를 출력합니다");
		int first = scan.nextInt();
		int second = scan.nextInt();
		System.out.println("덧셈결과= " + (first + second) );
		System.out.println("한글 1줄을 입력하면 한글을 출력합니다");
		scan.nextLine();
		String third = scan.nextLine();
		System.out.println(third);*/
		
		Scanner scan = new Scanner(System.in);
		System.out.println("2개의 정수를 입력하면 덧셈 결과를 출력합니다.");
		int first = scan.nextInt();
		int second = scan.nextInt();
		System.out.println("덧셈 결과 = "+(first+second));
		
		System.out.println("한글 데이터를 입력하면 한글을 출력합니다.");
		String third = scan.next();
		System.out.println(third);
		
		scan.nextLine();
		System.out.println("한글 1줄을 입력하면 한글을 출력합니다.");
		String fourth = scan.nextLine();
		System.out.println(fourth);

		
	}

}
