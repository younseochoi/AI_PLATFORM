package chap18;

import java.util.Scanner;

public class ScannerTest2 {

	public static void main(String[] args) {
		//쇼핑몰 메뉴
		//반복문 5번 입력하면 종료
		// 계속 1-4번 메뉴 보여주고 선택
		Scanner scan = new Scanner(System.in);
		while(true) {
		System.out.println("1. 회원가입 ");
		System.out.println("2. 로그인 ");
		System.out.println("3. 장바구니 ");
		System.out.println("4. 쇼핑 ");
		System.out.println("5. 종료 ");
		System.out.print("원하는 작업의 번호를 입력하세요 : ");
		
		int menu = scan.nextInt();
		if(menu == 5) {
			//System.exit(0); //프로그램 완전종료
			break;//현재 반복문만 종료(main 메소드 사용시
		} else if(menu == 1) {
			System.out.println("회원가입 화면으로 이동합니다");
			/*키보드로
			 * 아이디 : idtest
			 * 암호 : pwtest
			 * 
			 * 현재작업디렉토리\user.txt 파일 저장
			 * idtest pwtest 1 유저 가입 정보 저장
			 * ......
			 * 
			 * 
			 * */
		}else if(menu == 2) {
			System.out.println("로그인 화면으로 이동합니다");
			/*키보드로
			 * 로그인아이디 : idtest1
			 * 로그인암호 : pwtest1
			 * 
			 * 현재작업디렉토리\user.txt 파일에서 각 줄마다 조사
			 * idtest pwtest 조회
			 * 로그인아이디와 로그인암호 일치하는 줄이 있으면 "정상적으로 로그인되셨습니다 xxxx 회원님"
				로그인아이디와 로그인암호 일치하는 줄이 없으면 "회원 가입부터 하세요"
			 * 
			 * 
			 * */	
		}else if(menu == 3) {
			System.out.println("장바구니");
		}else if(menu == 4) {
			System.out.println("상품 리스트를 보여드립니다");
		}
		}//while end
	}//main

}




