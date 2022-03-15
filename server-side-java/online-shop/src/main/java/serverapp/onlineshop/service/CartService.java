package serverapp.onlineshop.service;

import serverapp.onlineshop.model.Cart;
import serverapp.onlineshop.model.CartLine;
import serverapp.onlineshop.model.User;

public interface CartService {

	Cart createCart(User user);

	Cart getCart(Long cartId);

	CartLine updateCart(long cartId, int quantity);

	CartLine addCartLine(long id);

//	Collection<Cart> getOrCreateCart(User user);
//
//	Cart getCart();
	
}
