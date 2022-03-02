package serverapp.onlineshop.service;

import serverapp.onlineshop.model.Cart;
import serverapp.onlineshop.model.CartLine;
import serverapp.onlineshop.model.Product;
import serverapp.onlineshop.model.User;

public interface CartService {

	Cart createCart(User user);

	Cart getCart(Long cartId);

	CartLine updateCart(long cartId, Product product, int quantity);

//	Collection<Cart> getOrCreateCart(User user);
//
//	Cart getCart();
	
}
