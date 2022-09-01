package product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("product_service")
public class ProductServiceImpl implements ProductService {
	@Autowired
	@Qualifier("product_dao")
	ProductDAO dao;
	
	@Override
	public List<ProductDTO> getAllProducts() {
		
		return dao.getAllProducts();
	}

	@Override
	public int getTotalBooks() {
		return dao.getCount();
	}
	
	@Override
	public List<ProductDTO> getBookList(int limit) {
		return dao.getBookList(limit);
	}
	
	@Override
	public List<ProductDTO> booklist() {
		List<ProductDTO> list = dao.getList();
		int count = dao.getCount();
		
		list.add(new ProductDTO(count, null, null, null, null, null, count, count));
		
		return list; //main 결과 리턴 - 갯수 마지막 객체 암호 포함 
	}
	
	@Override
	public List<ProductDTO> paginglist(int[] limit) {
		return dao.pagingList(limit);
	}
	
	@Override
	public List<ProductDTO> searchlist(ProductDTO dto) {
		return dao.searchList(dto);
	}
	
	
	
}//class
