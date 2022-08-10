package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MemberDTO;

public class MemberDAO {
	//MEMBER테이블 CRUD 
	public ArrayList<MemberDTO> selectAllMember() {
		Connection conn = null;
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();
		
		try {
			//1.context.xml 파일 정의 내용 읽어올 준비
			Context initContext = new InitialContext();
			
			//2. <Resource 이름 태그들  설정 읽어와
			Context envContext = (Context)initContext.lookup("java:/comp/env");// java - component - environment파일
			
			//3. jdbc/mydb 설정 태그만 읽어와서 connection pooling 클래스 객체 생성
			DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");	
			//4.
			conn = ds.getConnection();
			
		String sql = "select * from member"; 
		PreparedStatement pt = conn.prepareStatement(sql);
		ResultSet rs = pt.executeQuery();
		
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			//dto.setPassword(rs.getInt("password"));//insert(password, 0, repeat('*', 10)
			dto.setName(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			dto.setEmail(rs.getString("email"));
			dto.setRegdate(rs.getString("regdate"));// date_format(regdate, '%Y%m%d") 
			dto.getRegdate().substring(0, 10);
			memberlist.add(dto);
			
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();//connectionpool로 반납(null..)
			}catch(SQLException e) {   }
		}
		return memberlist;
	}//SELECTALLMEMBER


	public int selectMember(String id, String userpassword) {
		Connection conn = null;
		int condition = 0;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");//드라이버클래스 메모리 로딩
		conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/memberdb", "emp3", "emp3");
		//db연결(sql전송-결과검색작업보다 3-4배 시간, 메모리 많이 차지
		
		String sql = "select id, password from member where id=?";//member 테이블 id 컬럼 pk 
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setString(1, id);
		ResultSet rs = pt.executeQuery();
		//sql 실행 결과 여러개 레코드 검색되거나 1개 검색 --> 1번째 레코드 조회
		//sql 실행 결과 0개 검색
		
		String dbid=null, dbpassword=null;
		if(rs.next()) {
			condition = 1; //id 존재한다
			dbid = rs.getString("id");
			dbpassword = rs.getString("password");
			//id 존재하고 pw 동일하다
			if(dbpassword.equals(userpassword)) {
				condition = 2;
			}
		}
		else {
			//id 존재하지 않는다
			condition  = 3;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();//메모리정리시간.
			}catch(SQLException e) {   }
		}
		return condition;
	}

	public int insertMember(MemberDTO dto) {
		Connection conn = null;
		int condition = 0;//insert한 행의 갯수
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/memberdb", "emp3", "emp3");
		String sql = "insert into member values(?,?,?,?,?,now())";
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setString(1, dto.getId());
		pt.setInt(2, dto.getPassword());
		pt.setString(3, dto.getName());
		pt.setString(4, dto.getPhone());
		pt.setString(5, dto.getEmail());
		condition = pt.executeUpdate();
		/* dto 값 getter , 
		 * regdate컬럼입력값 - now()
		 * insert into member values(?,?,?,?,?,now())
		 *  */
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {   }
		}
		return condition;
	}//insertMember end
	
	public int deleteMember(String id, String pw) {
		Connection conn = null;
		int condition = 0;//delete한 행의 갯수
		try {
			//1.context.xml 파일 정의 내용 읽어올 준비
			Context initContext = new InitialContext();
			
			//2. <Resource 이름 태그들  설정 읽어와
			Context envContext = (Context)initContext.lookup("java:/comp/env");// java - component - environment파일
			
			//3. jdbc/mydb 설정 태그만 읽어와서 connection pooling 클래스 객체 생성
			DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");	
			//4.
			conn = ds.getConnection();
			
		String sql = "delete from member where id=? and password=?";
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setString(1, id);
		pt.setInt(2, Integer.parseInt(pw));
		condition = pt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {   }
		}
		return condition;
	}//deleteMember end

}//class
