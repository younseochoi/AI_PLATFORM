package board.spring.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("boardDAO")
public interface BoardDAO {
	
	
	public int insertBoard(BoardDTO dto);
	public int getBoardCount();

	public List<BoardDTO> getBoards(int[] page);
	public int updateViewcount(int seq);
	
	public BoardDTO getOneBoard(int seq);
	
	public int deleteBoard(int seq);
	
	public int updateBoard(BoardDTO dto);
}
