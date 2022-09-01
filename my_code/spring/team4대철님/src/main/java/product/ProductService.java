package product;

import java.util.List;

public interface ProductService {
	public List<ProductDTO> getAllProducts();
	public int getTotalBooks();
	public List<ProductDTO> getBookList(int limit);
	public List<ProductDTO> booklist();
	public List<ProductDTO> paginglist(int[] limit);
	public List<ProductDTO> searchlist(ProductDTO dto);
	/*
	public List<ProductDTO> getTotalBestseller(int page);
	public List<ProductDTO> getMonthBestseller(int page);
	*/
}
