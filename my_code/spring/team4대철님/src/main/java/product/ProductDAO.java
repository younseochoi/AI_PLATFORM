package product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("product_dao")
public class ProductDAO {
	
	@Autowired
	SqlSession session;
	
	public List<ProductDTO> getAllProducts(){
		return session.selectList("getAllProducts");
	}
	
	public int getTotalBooks() {
		return session.selectOne("getTotalBooks");
	}
	
	public List<ProductDTO> getBookList(int limit) {
		return session.selectList("getBookList", limit);
	}
	
	public List<ProductDTO> getBoookList(int limit) {
		return session.selectList("getBookList", limit);
	}
	
	public int getCount() {
		return session.selectOne("bookcount");
	}
	
	public List<ProductDTO> getList(){
		return session.selectList("product.booklist");
	}
	
	public List<ProductDTO> pagingList(int[] limit){
		return session.selectList("paginglist", limit);
	}
	
	public List<ProductDTO> searchList(ProductDTO dto){
		return session.selectList("searchlist" , dto);
	}
	
}//class
