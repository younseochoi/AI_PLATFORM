package board.spring.mybatis;

import java.util.List;

public interface BoardService {
	public int insertBoard(BoardDTO dto);
	public int getBoardCount();
	public List<BoardDTO> getBoards(int[] page);
	public BoardDTO getOneBoard(int seq);
	public int deleteBoard(int seq);
	public BoardDTO updateBoard(int seq);
	public void updateProcess(BoardDTO dto);
}
