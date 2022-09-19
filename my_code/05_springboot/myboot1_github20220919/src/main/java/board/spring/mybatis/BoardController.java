package board.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	@Autowired
	@Qualifier("boardservice")
	BoardService service;
	
	@RequestMapping("/")
	public String start() {
		return "board/start";
	}
	
	@GetMapping("/boardwrite")
	public String writeform() {
		return "board/writeform";
	}
	
	@PostMapping("/boardwrite")
	public ModelAndView writeProcess(BoardDTO dto) {
		ModelAndView mv = new ModelAndView();
		dto.setViewcount(0);
		int result = service.insertBoard(dto);
		mv.addObject("model", result);
		mv.setViewName("board/writeprocess");
		return mv;
	}
	
	@GetMapping("/boardlist")
	public ModelAndView boardlist(@RequestParam(value = "page" , required = false, defaultValue = "1" ) int page) {
		ModelAndView mv = new ModelAndView();
		int boardcount = service.getBoardCount();
		int paging = 3;
		List<BoardDTO> boardlist = service.getBoards(new int[] {(page-1)*paging, paging});
		mv.addObject("boardcount", boardcount);
		mv.addObject("boardlist", boardlist);
		mv.setViewName("board/list");
		return mv;
	}
	
	@GetMapping("/boarddetail")
	public ModelAndView getOneBoard(int seq) {
		ModelAndView mv = new ModelAndView();
		BoardDTO board = service.getOneBoard(seq);
		mv.addObject("board", board);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@PostMapping("/boarddelete")
	public String deleteProcess(int seq) {
		int result = service.deleteBoard(seq);
		return "redirect:/boardlist";
	}
	
	@GetMapping("/boardupdate")
	public  ModelAndView updateBoard(int seq) {
		ModelAndView mv = new ModelAndView();
		BoardDTO board = service.updateBoard(seq);
		mv.addObject("updateform", board);
		mv.setViewName("board/updateform");
		return mv;
	}
	
	@PostMapping("/boardupdate")
	public  String updateBoard(BoardDTO dto) {
		System.out.println(dto);
		service.updateProcess(dto);
	
		return "redirect:/boardlist";
	}
}
