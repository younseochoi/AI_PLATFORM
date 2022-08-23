package board.spring.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAO {
	@Autowired
	SqlSession session;
	
	public int insertBoard(BoardDTO dto) {
		return session.insert("board.insertboard",dto);
	}
	
	public int getBoardCount() {
		return session.selectOne("board.getboardcount");
	}

	public List<BoardDTO> getBoards(int[] page){
		return session.selectList("board.gettotalboards",page);
	}
	
	public int updateViewcount(int seq) {
		return session.update("board.updateviewcount",seq);
	}
	
	public BoardDTO getOneBoard(int seq) {
		return session.selectOne("board.getoneboard",seq);
	}
}
