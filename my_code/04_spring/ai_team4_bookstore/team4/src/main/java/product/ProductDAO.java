package product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product.parameter.ParameterDTO;

@Repository("product_dao")
public class ProductDAO {
	
	@Autowired
	SqlSession session;
	
	public List<ProductDTO> getAllProducts(){
		return session.selectList("getAllProducts");
	}
	
	public List<ProductDTO> getTotalBestseller(int page){
		return session.selectList("getTotalBestseller",page);
	}
	
	public List<ProductDTO> getMonthBestseller(int page){
		return session.selectList("getMonthBestseller",page);
	}
	
	public List<ProductDTO> getCategoryBestseller(ParameterDTO pdto){
		return session.selectList("getCategoryBestseller",pdto);
	}
	
	public List<ProductDTO> searchSimple(ProductDTO dto){
		return session.selectList("searchSimple", dto);
	}
	
	//승희
	public List<ProductDTO> searchList(ProductDTO dto){
		return session.selectList("searchlist", dto);
	}
	//대철
	public List<ProductDTO> getProductCategory(int category_id) {
		System.out.println(session.selectList("getProductCategory", category_id));
		return session.selectList("getProductCategory", category_id);
	}
	public ProductDTO getBook(int book_id){
		System.out.println(session.selectList("getBook", book_id));
		return session.selectOne("getBook", book_id);
	}//하나만 받아와서 one로 바꿈
}
