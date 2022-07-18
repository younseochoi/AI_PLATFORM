package chap18;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScannerTest2 {

	public static void main(String[] args) throws IOException {
		//쇼핑몰 메뉴
		//반복문 5번 입력하면 종료
		// 계속 1-4번 메뉴 보여주고 선택
		Scanner scan = new Scanner(System.in);
		FileWriter fw = new FileWriter("user.txt", true);
		
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
				System.out.print("아이디 : ");
			String id = scan.next();
			System.out.print("암호 : ");
			String pw = scan.next();
			fw.write(id + " " + pw + "\n");
			
		}else if(menu == 2) {
			System.out.print("로그인아이디 : ");
			String loginid = scan.next();
			System.out.print("로그인암호 : ");
			String loginpw = scan.next();
			
			FileReader fr = new FileReader("user.txt");//로그인 메뉴 선택시마다 파일 새로 입력
			Scanner sfr = new Scanner(fr);
			boolean exists = false;
			
			while(sfr.hasNextLine()) {//3번 반복
			String user =  sfr.nextLine();
			//System.out.println("-" + user + "-");
			//System.out.println("-" + loginid + " " + loginpw + "-");
			if(user.equals(loginid + " " + loginpw) ) { //2번줄
				System.out.println("정상적으로 로그인되셨습니다 " + loginid + " 회원님");
				exists = true;
				break;
			}
			}//while
			if(exists == false) {
				System.out.println("회원 가입부터 하세요");
			}
			sfr.close();
			fr.close();
		}else if(menu == 3) {
			System.out.println("장바구니");
		}else if(menu == 4) {
			System.out.println("상품 리스트를 보여드립니다");
		}
		}//while end

		fw.close();
	}//main

}




