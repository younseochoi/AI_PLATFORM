package product;

import java.util.List;

import product.parameter.ParameterDTO;

public interface ProductService {
	public List<ProductDTO> getAllProducts();
	public List<ProductDTO> getTotalBestseller(int page);
	public List<ProductDTO> getMonthBestseller(int page);
	public List<ProductDTO> getCategoryBestseller(ParameterDTO pdto);
	
	public List<ProductDTO> searchSimple(ProductDTO dto);
	
	
	
}
