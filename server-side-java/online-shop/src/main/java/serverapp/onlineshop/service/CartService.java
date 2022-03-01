package serverapp.onlineshop.service;

import java.util.Collection;
import java.util.List;

import serverapp.onlineshop.model.Cart;
import serverapp.onlineshop.model.User;

public interface CartService {

	Collection<Cart> createCart(User user);

	Cart getCart();
	
}
