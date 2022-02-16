package serverapp.onlineshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import serverapp.onlineshop.model.Product;
import serverapp.onlineshop.repository.ProductRepository;
import serverapp.onlineshop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{


	private ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;	
	}
	
	@Override
	public List<Product> getAllProducts() {
		return this.productRepository.findAll();
	}
	
	@Override
	public Product getProductById(long id) {
		if(this.productRepository.existsById(id)) return this.productRepository.findById(id).get();
		else return null;
	}

	@Override
	public Product addProduct(Product product) {
		return this.productRepository.save(product);
	}
	
	@Override
	public boolean addSomeProducts(List<Product> products) {
		for (Product product : products) {
			this.productRepository.save(product);
		}
		return true;
	}
	
	@Override
	public boolean isProductExists(Product product) {
		List<Product> products = this.productRepository.findAll();
		for (Product p : products) {
			if(product.compareTo(p) == 0) return true;
		}
		return false;
	}

	@Override
	public Product updateProduct(Product product) {
		System.out.println(product.getId());
		if(this.productRepository.existsById(product.getId())) return this.productRepository.save(product);
		else return null;
	}

}
