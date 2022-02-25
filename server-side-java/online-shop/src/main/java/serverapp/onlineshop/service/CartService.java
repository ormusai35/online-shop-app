package serverapp.onlineshop.service;

import java.util.List;

import serverapp.onlineshop.model.Cart;
import serverapp.onlineshop.model.User;

public interface CartService {

//	Cart createCart();

	List<Cart> getCart(User user);
	
}
