package spring.mybatis;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringMain {

	public static void main(String[] args) throws IOException {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring/mybatis/spring-mybatis.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder(); //설정 파일 읽을 준비
		
		//SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/mybatis-config.xml"));
		
		//db 연결
		//SqlSession session =  factory.openSession(true);
		MemberService service = (MemberService) factory.getBean("service");
		
//		//sql 실행
//		List<MemberDTO> list = session.selectList("member.memberlist"); // namespace.selectid
//		
//		//조회
//		for(MemberDTO dto:list) {
//			System.out.println(dto);
//		}
//		int count = session.selectOne("membercount");
//		System.out.println("총회원수 : "+count);
		
	
		List<MemberDTO> list = service.memberlist();
		
		for(int i = 0 ;i < list.size()-1;i++) {
			System.out.println(list.get(i));
		}
		
		int count = list.get(list.size()-1).getPassword();
		System.out.println("총 회원수는?! : "+count);
		
		//특정 멤버 조회
		Scanner sc = new Scanner(System.in);
		System.out.println("조회할 회원 아이디를 입력하세요");
		String id = sc.next();
		List<MemberDTO> list2 = service.oneMember(id);
		for(MemberDTO dto : list2) {
			System.out.println(dto.getId()+" : "+dto.getName());
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------");
		//페이징 처리
		System.out.println("페이지를 입력해주세요.");
		int page = sc.nextInt();
		int num = 4;
		int[] limit = {(page-1)*num, num};
		List<MemberDTO> list3 = service.paginglist(limit);
		for(MemberDTO dto : list3) {
			System.out.println(dto);
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------");
//		<!-- 
//		MemberMain 
//		1>MemberDTO dto = new MemberDTO();
//		dto.setId("");
//		dto.setPassword(숫자);
//		dto.setName("");
//		dto.setPhone("");
//		dto.setEmail("");
//		2>service.registerMember(dto) 전달 호출
//
//		3>service.registerMember(MemberDTO dto){  정의
//		   List<MemberDTO> list = dao.oneMember(dto.getId());
//		   if( linst == null || list.size() == 0) {
//		   dao.insertMember(dto);
//		   }
//		   
//		4> dao.insertMember(MemberDTO dto){ 정의
//		  session.insert("insertmember", dto)
//		  }  
//		}
//		-->
//		<insert id="insertmember" parameterType="mybatis.MemberDTO" >
//		 insert into member values(#{id},#{password},#{name},#{phone},#{email},now()) 
//		</insert>
//		MemberDTO dto = new MemberDTO();
//		dto.setId("yaamr");
//		dto.setPassword(1010);
//		dto.setName("batis");
//		dto.setEmail("batibati@my.com");
//		dto.setPhone("010-1010-1919");
//		dto.setRegdate("2022-08-19");
//		int result = service.registerMember(dto);
//		if(result >=1) {
//			System.out.println("정상적으로 등록하였습니다.");
//			System.out.println(result);
//		}else if(result == -1) {
//			System.out.println("중복 아이디가 존재합니다.");
//		}else {
//			System.out.println("등록실패");
//		}
		
//		System.out.println("수정할 아이디를 입력하세요.");
//		String input_id = sc.next();
//		List<MemberDTO> selectlist = service.oneMember(input_id);
//		System.out.println("수정할 회원정보를 입력하세요.(컬럼명 = 변경값의 형식)");
//		String updateInfrom = sc.next();
//		MemberDTO updatedto = new MemberDTO();
//		updatedto.setId(input_id);
//		String colname = updateInfrom.split("=")[0];
//		String colValue = updateInfrom.split("=")[1];
//		if(colname.equals("name")) {
//			updatedto.setName(colValue);
//			updatedto.setEmail(selectlist.get(0).getEmail());
//			updatedto.setPhone(selectlist.get(0).getPhone());
//		}else if(colname.equals("email")) {
//			updatedto.setEmail(colValue);
//			updatedto.setName(selectlist.get(0).getName());
//			updatedto.setPhone(selectlist.get(0).getPhone());
//		}else if(colname.equals("phone")) {
//			updatedto.setPhone(colValue);
//			updatedto.setEmail(selectlist.get(0).getEmail());
//			updatedto.setName(selectlist.get(0).getName());
//	}
//		int result = service.updateMember(updatedto);
//		System.out.println(result);
//		
//		System.out.println("삭제할 아이디를 입력하세요.");
//		input_id = sc.next();
//		int deleteresult = service.deleteMember(input_id);

}
}
