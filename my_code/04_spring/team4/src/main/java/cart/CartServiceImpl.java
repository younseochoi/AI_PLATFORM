package cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("cart_service")
public class CartServiceImpl implements CartService {

	@Autowired
	@Qualifier("cart_dao")
	CartDAO dao;
	
	@Override
	public List<CartDTO> getCart(int member_id) {
		
		return dao.getCart(member_id);
	}

	@Override
	public List<CartDTO> getCount(int member_id) {
		
		return dao.getCount(member_id);
	}

	@Override
	public List<CartDTO> getTotal(int member_id) {
		return dao.getTotal(member_id);
	}
	
	@Override
	public List<CartDTO> insertIntoCart(CartDTO dto) {
		return dao.insertIntoCart(dto);
		

	}
	
	@Override
	public List<CartDTO> search(CartDTO dto){
		return dao.search();
	}

	
}
