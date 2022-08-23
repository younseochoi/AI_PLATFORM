package board.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("boardService")
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
	
	

	
}
