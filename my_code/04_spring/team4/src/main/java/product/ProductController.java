package product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import product.parameter.ParameterDTO;

@Controller
public class ProductController {
	
	@Autowired
	@Qualifier("product_service")
	ProductService service;
	
//	@RequestMapping("/allproduct")
//	public ModelAndView getAllProducts() {
//		ModelAndView mv = new ModelAndView();
//		List<ProductDTO> product_list = service.getAllProducts();
//		mv.addObject("product_list", product_list);
//		mv.setViewName("product/cart");
//		return mv;
//	}
	@RequestMapping("/allproduct")
	public String getAllProducts() {
		//ModelAndView mv = new ModelAndView();
		//List<ProductDTO> product_list = service.getAllProducts();
		//mv.addObject("product_list", product_list);
		//mv.setViewName("product/cart");
		return "product/cart";
	}
	
	 //전체 베스트셀러 리스트 가져오기
	@RequestMapping(value="/totalbestseller", produces= {"application/json;charset=utf-8"})
	@ResponseBody
	public List<ProductDTO> getTotalBestseller(int page) {
		System.out.println(page);
		List<ProductDTO> product_list = service.getTotalBestseller(page);
		return product_list;
	}
	
	 //이번달 베스트셀러 리스트 가져오기
	@RequestMapping(value="/monthbestseller", produces= {"application/json;charset=utf-8"})
	@ResponseBody
	public List<ProductDTO> getMonthBestseller(int page) {
		System.out.println(page);
		List<ProductDTO> product_list = service.getMonthBestseller(page);
		return product_list;
	}
	
	 //카테고리별 베스트셀러 리스트 가져오기
	@RequestMapping(value="/categorybestseller", produces= {"application/json;charset=utf-8"})
	@ResponseBody
	public List<ProductDTO> getCategoryBestseller(int page, String category) {
		if(category.equals("novel")) {
			category="소설";
		}else if(category.equals("poetry")) {
			category="시";
		}else if(category.equals("human")) {
			category="인문학";
		}else if(category.equals("science")) {
			category="과학";
		}else {
			category="it";
		}
		//System.out.println(page+" category :: "+category);
		ParameterDTO parameter_dto = new ParameterDTO();
		parameter_dto.setPage((page-1)*4);
		parameter_dto.setCategory(category);
		List<ProductDTO> product_list = service.getCategoryBestseller(parameter_dto);
		return product_list;
	}
	
	@RequestMapping("/search")
//	@ResponseBody
	public ModelAndView searchSimple(@RequestParam(value="search_select",required =true)String search_select ,  @RequestParam(value="keyword" , required = true) String keyword){
		ModelAndView mv = new ModelAndView();
		ProductDTO dto = new ProductDTO();
		//System.out.println(search_select+" :: :: "+keyword);
		if(search_select.equals("title")) {
			dto.setTitle(keyword);
		}else if(search_select.equals("writer")) {
			dto.setWriter(keyword);
		}else if(search_select.equals("publisher")) {
			dto.setPublisher(keyword);
		}
		List<ProductDTO> product_list = service.searchSimple(dto);
		mv.setViewName("product/simplesearchresult");
		mv.addObject("search_result", product_list);
		return mv;
	}
	
	
	
//	@RequestMapping("/search")
////	@ResponseBody
//	public ModelAndView searchSimple(String search_select , String keyword){
//		ModelAndView mv = new ModelAndView();
//		ProductDTO dto = new ProductDTO();
//		System.out.println(search_select+" :: :: "+keyword);
//		if(search_select.contains("title")) {
//			dto.setTitle(keyword);
//		}else if(search_select.contains("writer")) {
//			dto.setWriter(keyword);
//		}else if(search_select.contains("publisher")) {
//			dto.setPublisher(keyword);
//		}
//		List<ProductDTO> product_list = service.searchSimple(dto);
//		mv.setViewName("product/simplesearchresult");
//		mv.addObject("search_result", product_list);
//		return mv;
//	}
	


}
