package serverapp.onlineshop.service;

import java.util.List;

import serverapp.onlineshop.model.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(long id);
	
	Product addProduct(Product product);
	
	boolean addSomeProducts(List<Product> products);

	boolean isProductExists(Product product);

	Product updateProduct(Product product);

}
