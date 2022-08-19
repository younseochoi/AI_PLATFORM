package mybatis;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberMain {

	public static void main(String[] args) throws IOException {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();//설정파일 읽을 준비
		SqlSessionFactory factory = builder.build
				( Resources.getResourceAsReader("mybatis/mybatis-config.xml") );
		//db 연결
		SqlSession session = factory.openSession();
		
		//  MEMBERLIST - 전체 리스트 + 회원수
		MemberDAO dao = new MemberDAO();
		dao.setSession(session);//sql 실행 
		
		MemberServiceImpl service = new MemberServiceImpl();
		service.setDao(dao);//dao 일 시킨다
		List<MemberDTO> list = service.memberlist();
		
		for(int i = 0; i < list.size()-1; i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("총회원수 =" + list.get( list.size()-1 ).getPassword());
		
		//특정 멤버 조회
		//키보드 입력 id 조회
		Scanner key = new Scanner(System.in);
		System.out.println("조회할 회원의 아이디를 입력하세요");
		String id = key.next();
		//MemberDTO dto = service.onemember(id);
		List<MemberDTO> list2 = service.onemember(id);
		for(MemberDTO dto : list2) {
			System.out.println(dto.getId() + ":" + dto.getName());
		}
		
		System.out.println("============================================");
		//페이징처리
		int[] limit= {0, 4};
		List<MemberDTO> list3 = service.paginglist(limit);
		for(MemberDTO dto : list3) {
			System.out.println(dto);
		}
		System.out.println("============================================");
		
		
		/*
		//sql 실행 = 메소드 = DAO , 기능단위 = 메소드 = 서비스
		List<MemberDTO> list = session.selectList("member.memberlist");
		
		//조회
		for(MemberDTO dto :list) {
			System.out.println(dto);
		}
		
		int count = session.selectOne("membercount");
		System.out.println("총 회원수=" + count);*/
		
		//저장
/*		MemberDTO dto = new MemberDTO();
		dto.setId("mybatis2");
		dto.setPassword("mybatis2");
		dto.setName("홍길동");
		dto.setPhone("019-0000-9999");
		dto.setEmail("mybatis2@a.com");
		int insertrow = service.insertmember(dto);
		System.out.println(insertrow);*/
	}

}




