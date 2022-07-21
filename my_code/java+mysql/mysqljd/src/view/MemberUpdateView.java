package view;

import java.util.Scanner;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberUpdateView implements view {

	@Override
	public void input() {
		/* 아이디 : xxxx 
		 * 수정항목 : 암호|이름|폰번호|이메일 
		 * 수정값 : ㅌㅌㅌ 
		 * MeberDAO 의updateEmp(MemberDto dto ) 호출 
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 : ");
		String id = sc.next();
		System.out.println("수정항목 : 1. 암호 2. 이름 3. 폰번호 4. 이메일 ");
		int option = sc.nextInt();
		System.out.println("수정값 : ");
		String updateValue = sc.next();
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		if(option ==1) {
			dto.setPassword(Integer.parseInt(updateValue));
		}else if(option ==2) {
			dto.setName(updateValue);
		}else if(option ==3) {
			dto.setPhone(updateValue);
		}else if(option ==4) {
			dto.setEmail(updateValue);
		}else {
			System.out.println("잘못된 옵션 선택입니다. 다시 시도하여 주세요.");
			return;
		}
		
		MemberDAO dao = new MemberDAO();
		int result = dao.updateMember(dto,option);
		if(result ==0)
		System.out.println("업데이트 완료");
		else {
			System.out.println("업데이트 실패");
		}
	}

}
