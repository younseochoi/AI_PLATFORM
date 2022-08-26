package board.spring.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boarddao")
public class BoardDAO {
	@Autowired
	SqlSession session;
	
	public int insertBoard(BoardDTO dto) {
		return session.insert("insertboard", dto);
	}
	
	public int getTotalBoard() {
		return session.selectOne("getTotalBoard");
	}
	
	public List<BoardDTO> getBoardList(int limit) {
		return session.selectList("getBoardList", limit);
	}
	
	public void updateViewcount(int seq) {
		session.update("updateViewcount", seq);
	}
	
	public BoardDTO getDetail(int seq) {
		return session.selectOne("getDetail", seq);
	}
	
	public void deleteBoard(int seq) {
		session.delete("deleteBoard", seq);
	}
	
	public void updateBoard(BoardDTO dto) {
		session.update("updateBoard", dto);
	}
}






