package board.spring.mybatis;

import java.util.List;

public interface BoardService {
	public int registerBoard(BoardDTO dto) ;
	public int getTotalBoard();
	public List<BoardDTO> getBoardList(int limit);
}
