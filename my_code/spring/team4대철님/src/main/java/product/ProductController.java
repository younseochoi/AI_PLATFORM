package product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	@Autowired
//	@Qualifier("product_service")
	ProductService service;
	
	@RequestMapping("/searchmain")
	public String searchmain() {
		return "product/searchmain";
	}
	/*
	@RequestMapping("/searchdetail")
	public String searchdetail() {
		return "product/searchdetail";
	}*/
	
	@RequestMapping("/books") //sql확인용 전체 데이터 불러오기
	public ModelAndView getAllProducts() {
		ModelAndView mv = new ModelAndView();
		List<ProductDTO> product_list = service.getAllProducts();
		
		mv.addObject("product_list", product_list);
		mv.setViewName("product/test");
		return mv;
	}
	
	@RequestMapping("/searchdetail")
	public ModelAndView memberlist(String item, String searchword) {
		//item - 제목 검색 / 저자 검색 ....
		ProductDTO dto = new ProductDTO();
		if(item.contains("제목")) {
			dto.setTitle(searchword); //name != null -- #{name}<=searchword
		}
		else if(item.contains("저자")) {
			dto.setWriter(searchword);
		}
		else if(item.contains("출판사")) {
			dto.setPublisher(searchword);
		}
		List<ProductDTO> booklist = service.searchlist(dto);
		System.out.println(booklist.size());
		ModelAndView mv = new ModelAndView();
		mv.addObject("booklist", booklist);
		mv.setViewName("product/searchdetail");
		return mv;
	}
	
	/*
	@RequestMapping("/bookpaginglist") //sql확인용 전체 데이터 불러오기
	public ModelAndView booklist(@RequestParam(value="page", required = false, defaultValue="1") int page) {
		//총 책의 개수
		int totalbooks = service.getTotalBooks();
		//현재페이지 4개만 조회
		int start = (page-1)*4; // 0~4보여주기
		List<ProductDTO> booklist = service.paginglist(new int[] {start, 4});
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("booklist", booklist);
		mv.addObject("totalbooks", totalbooks);
		
		mv.setViewName("product/bookpaginglist");
		return mv;
	}
	*/

	
}//class
