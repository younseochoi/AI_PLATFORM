package board.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("boardservice")
public class BoardServiceImpl implements BoardService {

	@Autowired
	@Qualifier("boardDAO")
	BoardDAO dao;
	
	@Override
	public int insertBoard(BoardDTO dto) {
		return dao.insertBoard(dto);
	}

	@Override
	public int getBoardCount() {
		return dao.getBoardCount();
	}

	@Override
	public List<BoardDTO> getBoards(int[] page) {
		return dao.getBoards(page);
	}

	@Override
	public BoardDTO getOneBoard(int seq) {
		dao.updateViewcount(seq);
		return dao.getOneBoard(seq);
	}

	@Override
	public int deleteBoard(int seq) {
		return dao.deleteBoard(seq);
	}

	@Override
	public BoardDTO updateBoard(int seq) {
		return dao.getOneBoard(seq);
	}

	@Override
	public void updateProcess(BoardDTO dto) {
		int result = dao.updateBoard(dto);
		System.out.println(result);
	}
	
	
	
	

	
}
