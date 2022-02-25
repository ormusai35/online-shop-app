package serverapp.onlineshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import serverapp.onlineshop.model.Cart;
import serverapp.onlineshop.model.User;
import serverapp.onlineshop.repository.CartRepository;
import serverapp.onlineshop.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;

//	@Override
//	public Cart createCart() {
//		Cart cart = new Cart();
//		return this.cartRepository.save(cart);
//	}

	@Override
	public List<Cart> getCart(User user) {
		List<Cart> carts = this.cartRepository.findByUserId(user.getId());
//		if(cart == null) cart = new Cart(user);
		return carts;
	}
	
	
}
