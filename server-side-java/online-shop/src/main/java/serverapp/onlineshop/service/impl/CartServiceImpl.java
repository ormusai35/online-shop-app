package serverapp.onlineshop.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import serverapp.onlineshop.model.Cart;
import serverapp.onlineshop.model.User;
import serverapp.onlineshop.repository.CartLineRepository;
import serverapp.onlineshop.repository.CartRepository;
import serverapp.onlineshop.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartLineRepository cartLineRepository;

	@Override
	public Cart createCart(User user) {
		Cart cart;
		if(user == null) cart = new Cart();
		else cart = new Cart(user);
		return this.cartRepository.save(cart);
	}

	@Override
	public Cart getCart(Long cartId) {
		return this.cartRepository.getById(cartId);
	}
	
	
}
