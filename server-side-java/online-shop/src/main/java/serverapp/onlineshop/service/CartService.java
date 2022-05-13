package serverapp.onlineshop.service;

import java.util.List;

import serverapp.onlineshop.model.Cart;
import serverapp.onlineshop.model.CartLine;
import serverapp.onlineshop.model.Product;
import serverapp.onlineshop.model.User;

public interface CartService {

	Cart createCart(User user);

	Cart getCart(Long cartId);

	Cart updateCart(Cart cart, Product priduct, int quantity);

	CartLine addCartLine(long id);

	List<Cart> getCarts();

//	Collection<Cart> getOrCreateCart(User user);
//
//	Cart getCart();
	
}
