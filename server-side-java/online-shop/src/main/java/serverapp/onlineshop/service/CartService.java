package serverapp.onlineshop.service;

import java.util.Collection;
import java.util.List;

import serverapp.onlineshop.model.Cart;
import serverapp.onlineshop.model.User;

public interface CartService {

	Cart createCart(User user);

	Cart getCart(Long cartId);

//	Collection<Cart> getOrCreateCart(User user);
//
//	Cart getCart();
	
}
