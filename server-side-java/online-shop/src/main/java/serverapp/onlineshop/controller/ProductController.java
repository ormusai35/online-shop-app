package serverapp.onlineshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import serverapp.onlineshop.model.Product;
import serverapp.onlineshop.service.ProductService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping(path="products")
	public List<Product> getProducts(){
		return this.productService.getAllProducts();
	}
}
