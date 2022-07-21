package view;

import java.util.Scanner;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberInsertView implements view{
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 입력 : ");
		String id = sc.next();
		System.out.print("암호 입력 : ");
		int password = sc.nextInt();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("폰번호 입력 : ");
		String phone = sc.next();
		System.out.print("이메일 입력 : ");
		String email = sc.next();
		// now()
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPassword(password);
		dto.setName(name);
		dto.setPhone(phone);
		dto.setEmail(email);

		MemberDAO dao = new MemberDAO();
		int result = dao.insertMember(dto);
		System.out.println(result); // 
	}
}
