package spring.mybatis;

import java.io.IOException;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.naming.java.javaURLContextFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) throws IOException {
		//@annotation + mybatis config 파일명 설정
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("spring/mybatis/spring-mybatis.xml");
		
		MemberService service = (MemberService) factory.getBean("service");
			
		
		//전체리스트
	java.util.List<MemberDTO> list = service.memberlist();
		
		for(int i = 0; i < list.size()-1; i++) {
			System.out.println(list.get(i));
		}
		//총회원수
		//System.out.println("총회원수 =" + list.get( list.size()-1 ).getPassword());
		
		//특정 멤버 조회
		//키보드 입력 id 조회
	/*	Scanner key = new Scanner(System.in);
		System.out.println("조회할 회원의 아이디를 입력하세요");
		String id = key.next();
		//MemberDTO dto = service.onemember(id);
		List<MemberDTO> list2 = service.onemember(id);
		for(MemberDTO dto : list2) {
			System.out.println(dto.getId() + ":" + dto.getName());
		}
	*/	
		/*System.out.println("============================================");
		//페이징처리
		int[] limit= {0, 4};
		List<MemberDTO> list3 = service.paginglist(limit);
		for(MemberDTO dto : list3) {
			System.out.println(dto);
		}
		System.out.println("============================================");
		*/
		//insert
/*		MemberDTO insertdto = new MemberDTO();
		insertdto.setId("mybatis2");
		insertdto.setPassword(1111);
		insertdto.setName("홍길동");
		insertdto.setPhone("01009870988");
		insertdto.setEmail("hong@kil.con");
		
		int result = service.registerMember(insertdto);
		System.out.println(result);
		//session.commit();//방법1
*/
		
		//수정
/*		Scanner key = new Scanner(System.in);
		System.out.println("수정할 회원의 아이디를 입력하세요");
		String id = key.next();
		List<MemberDTO> selectlist = service.onemember(id);//조회정보저장
		// member 테이블 id 컬럼 pk 설정 x - 여러개 나올 수 있다.
		
		System.out.println("수정할 회원의 정보를 입력하세요(컬럼명=변경값의 형식으로 입력하세요)");
		String updateInform = key.next();   //name email phone
		
		MemberDTO updatedto = new MemberDTO();
		updatedto.setId(id);
		String colName = updateInform.split("=")[0];
		String colValue = updateInform.split("=")[1];
		if(colName.equals("name")) {
			updatedto.setName(colValue);//이름 수정
			updatedto.setEmail(selectlist.get(0).getEmail());//이메일 원래값 
			updatedto.setPhone(selectlist.get(0).getPhone());//폰번호 원래값 
		}
		else if(colName.equals("email")) {
			updatedto.setEmail(colValue);
			updatedto.setName(selectlist.get(0).getName());//이름 원래값
			updatedto.setPhone(selectlist.get(0).getPhone());//폰번호 원래값
		}
		else if(colName.equals("phone")) {
			updatedto.setPhone(colValue);
			updatedto.setName(selectlist.get(0).getName());//이름 원래값
			updatedto.setEmail(selectlist.get(0).getEmail());//이메일 원래값
		}
		
		int result = service.updateMember(updatedto);
		System.out.println(result);
		// db 확인
*/
		//삭제
/*		Scanner key = new Scanner(System.in);
		System.out.println("수정할 회원의 아이디를 입력하세요");
		String id = key.next();		
		int result = service.deleteMember(id);
		if(result == 0) {
			System.out.println("가입조차 한 적이 없습니다. ");
		}
		else {
			System.out.println("정상적으로 삭제처리되었습니다.");
		}
*/		
		
		
		
		
		
		/*
		//sql 실행 = 메소드 = DAO , 기능단위 = 메소드 = 서비스
		List<MemberDTO> list = session.selectList("member.memberlist");
		
		//조회
		for(MemberDTO dto :list) {
			System.out.println(dto);
		}
		
		int count = session.selectOne("membercount");
		System.out.println("총 회원수=" + count);*/
		

		
	}

}




