package cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

	@Autowired
	HttpSession session;
	
	@Autowired
	@Qualifier("cart_service")
	CartService service;

	/*

	@RequestMapping("/cart")
	public ModelAndView getProducts() {
		ModelAndView mv = new ModelAndView();
		List<CartDTO> cart_list = service.getCart();
		List<CartDTO> sumproduct = service.getTotal();
		List<CartDTO> totalcount = service.getCount();
		int delivery = 0;
		if(sumproduct.get(0).sumproduct >= 50000) {
			delivery = 0;
		}
		else {delivery = 3000;}
		mv.addObject("delivery", delivery);
		mv.addObject("cart_list", cart_list);
		mv.addObject("sumproduct", sumproduct);
		mv.addObject("totalcount", totalcount);
		mv.setViewName("cart/cart");
		return mv;
		
	}
	*/
	
	

	@RequestMapping("/cart2")
	public ModelAndView getData() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("member_id", 1);
//		mv.setViewName("product/productdetail");
		mv.setViewName("cart/cart");
		return mv;
	
	}
	
	
	@RequestMapping(value="/cart/{member_id}")
	public ModelAndView goCart(@PathVariable int member_id, int book_id, HttpServletRequest request) {
		session = request.getSession();
		String id = (String) session.getAttribute("sessionid");
		System.out.println(member_id);
		ModelAndView mv = new ModelAndView();
		List<CartDTO> cart_list = service.getCart(member_id);
		List<CartDTO> sumproduct = service.getTotal(member_id);
		List<CartDTO> totalcount = service.getCount(member_id);
		int delivery = 0;
		if(sumproduct.get(0).sumproduct >= 50000) {
			delivery = 0;
		}
		else {delivery = 3000;}
		mv.addObject("delivery", delivery);
		mv.addObject("cart_list", cart_list);
		mv.addObject("sumproduct", sumproduct);
		mv.addObject("totalcount", totalcount);
		mv.setViewName("cart/cart");
		return mv;
	}
	
	
	
	
	
/*
	@GetMapping("/cart2/${member_id}")
	public String GetMemberId(@PathVariable("member_id") int member_id) {
		System.out.println(member_id);
		return "/cart";
	}
*/	
}
