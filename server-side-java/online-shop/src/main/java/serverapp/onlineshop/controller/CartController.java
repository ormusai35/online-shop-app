package serverapp.onlineshop.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import serverapp.onlineshop.model.Cart;
import serverapp.onlineshop.model.User;
import serverapp.onlineshop.service.CartService;
import serverapp.onlineshop.service.UserService;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
public class CartController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;
	
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
	
//	@GetMapping(path="get-cart/test")
//	public Cart getCart() {
//		return this.cartService.getCart();
//	}
}
