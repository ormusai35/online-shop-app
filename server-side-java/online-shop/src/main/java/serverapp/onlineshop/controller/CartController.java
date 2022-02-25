package serverapp.onlineshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import serverapp.onlineshop.model.Cart;
import serverapp.onlineshop.model.User;
import serverapp.onlineshop.service.CartService;
import serverapp.onlineshop.service.UserService;

@RestController
public class CartController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;
	
	@GetMapping(path="get-cart-by-user/{userId}")
	public List<Cart> createCart(@PathVariable Long userId) {
		User user = this.userService.getUserById(userId);
		return this.cartService.getCart(user);
	}
}
