package review;

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
public class ReviewController {
	@Autowired
	@Qualifier("review_service")
	ReviewService service;
	
	@GetMapping("/reviewwrite")
	public String writingform() {
		return "review/writingform";
	}
	
	/*
	@PostMapping("/reviewwrite")
	public ModelAndView writingprocess(ReviewDTO dto) {
		int insertcount = service.registerReview(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("insertcount", insertcount);
		mv.setViewName("review/writingprocess");
		return mv;
	}
	*/
	
	@PostMapping("/reviewwrite")
	String registerReview(ReviewDTO dto) {
		service.registerReview(dto);
		return "redirect:/productdetail?book_id="+dto.getBook_id();
	}
	
//	@PostMapping("/updatereview")
//	String updateReview(ReviewDTO dto) {
//		service.updateReview(dto);
//		return "redirect:/reviewwrite";
//	}

	
};