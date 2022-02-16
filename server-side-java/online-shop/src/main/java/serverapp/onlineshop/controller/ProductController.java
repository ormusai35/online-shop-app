package serverapp.onlineshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import serverapp.onlineshop.model.Product;
import serverapp.onlineshop.service.ProductService;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping(path="products")
	public ResponseEntity<List<Product>> getProducts(){
		return ResponseEntity.ok(this.productService.getAllProducts());
	}
	
	@GetMapping(path="get-product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id){
		Product p = this.productService.getProductById(id);
		return ResponseEntity.ok(p);
	}
	
	@PostMapping(path="insert-new-product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		if(this.productService.isProductExists(product)) return null;
		else return ResponseEntity.ok(this.productService.addProduct(product));
	}
	
	
	@PutMapping(path="update-product")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		return ResponseEntity.ok(this.productService.updateProduct(product));
	}
	
	@PostMapping(path="add-some-product")
	public boolean addProducts(@RequestBody List<Product> products) {
		return this.productService.addSomeProducts(products);
	}
	
}
