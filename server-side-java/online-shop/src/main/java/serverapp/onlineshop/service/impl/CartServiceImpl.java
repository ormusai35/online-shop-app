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
	public Cart getCart() {
//		List<Cart> carts = this.cartRepository.findByUserId(user.getId());
//		return carts;
//		return this.cartRepository.findAllCartsByPrice();
//		return this.cartRepository.findByTotal(50);
		return this.cartRepository.findById(1L).get();
	}

	@Override
	public Collection<Cart> createCart(User user) {
//		Cart cart = this.cartRepository.findByUser(userId);
//		return this.cartRepository.save(cart);
		
		return this.cartRepository.findByUser(user);
	}
	
	
}
