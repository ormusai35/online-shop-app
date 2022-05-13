package serverapp.onlineshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import serverapp.onlineshop.model.Cart;
import serverapp.onlineshop.model.CartLine;
import serverapp.onlineshop.model.Product;
import serverapp.onlineshop.model.User;
import serverapp.onlineshop.service.CartService;
import serverapp.onlineshop.service.ProductService;
import serverapp.onlineshop.service.UserService;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
public class CartController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(path="get-cart-by-user/{userId}")
	public ResponseEntity<Cart> getOrCreateCart(@PathVariable Long userId) {
		Cart cart;
		User user = this.userService.getUserById(userId);	
		if (user == null) 
			cart = this.cartService.createCart(user);
		else {
			cart = user.getCart();
			if(cart == null) cart = this.cartService.createCart(user);
			user.setCart(cart);
			this.userService.updateUser(user);
		}
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	@GetMapping(path="update-cart-test")
	public ResponseEntity<Cart> addProductToCart(@RequestParam Long cartId, @RequestParam Long productId, @RequestParam Integer quantity){
		
		Cart cart = this.cartService.getCart(cartId);
		Product product = this.productService.getProductById(productId);
		
		return new ResponseEntity<Cart>(this.cartService.updateCart(cart, product, quantity),HttpStatus.OK);
	}
	
	@PostMapping(path="add-cart-line/{id}")
	public ResponseEntity<CartLine> addCartLine(@PathVariable long id) {
		return new ResponseEntity<CartLine>(this.cartService.addCartLine(id),HttpStatus.OK);
	}
	
//	@PostMapping(path="update-cart")
//	public ResponseEntity<CartLine> addProductToCart(@RequestParam long cartId, @RequestBody Product product, @RequestParam int quantity){
//		return new ResponseEntity<CartLine>(this.cartService.updateCart(cartId, product, quantity),HttpStatus.OK);
//	}
	
	@GetMapping(path="get-carts/test")
	public List<Cart> getCart() {
		return this.cartService.getCarts();
	}
}
