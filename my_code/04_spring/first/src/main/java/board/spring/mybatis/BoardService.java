package board.spring.mybatis;

import java.util.List;

public interface BoardService {
	public int insertBoard(BoardDTO dto);
	public int getBoardCount();
	public List<BoardDTO> getBoards(int[] page);
	public BoardDTO getOneBoard(int seq);
}
