package cart;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cart_dao")
public class CartDAO {
	
	@Autowired
	SqlSession session;
	
	public List<CartDTO> getCart(int member_id){
		return session.selectList("getCart", member_id);
		//getProducts sql 받아서 return
	}
	
	public List<CartDTO> getCount(int member_id){
		return session.selectList("getCount", member_id);
	}
	
	public List<CartDTO> getTotal(int member_id) {
		return session.selectList("getTotal", member_id);
		
	}
	public List<CartDTO>  insertIntoCart(CartDTO dto) {
		return session.selectList("insertIntoCart");
	}
	
	public List<CartDTO> search(){
		return session.selectList("search");
	}
}

