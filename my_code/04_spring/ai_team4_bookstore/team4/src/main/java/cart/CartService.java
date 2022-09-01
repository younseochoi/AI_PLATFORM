package cart;

import java.util.List;

import product.ProductDTO;

public interface CartService {
	public List<CartDTO> getCart(int member_id);
	public List<CartDTO> getCount(int member_id);
	public List<CartDTO> getTotal(int member_id);
	public List<CartDTO> insertIntoCart(CartDTO dto);
	public List<CartDTO> search(CartDTO dto);
}
