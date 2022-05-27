package serverapp.onlineshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import serverapp.onlineshop.model.Cart;
import serverapp.onlineshop.model.CartLine;
import serverapp.onlineshop.model.Product;
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
		return this.cartRepository.findByCartId(cartId);
	}

	@Override
	public void updateCart(Cart cart, Product product, int quantity) {
		
		if(cart.getCartLines().stream()
				.anyMatch(c -> c.getProduct().getId() == product.getId()))
		{
			System.out.println("!!!!!!!!!!!! update !!!!!!!!!!!!!");
			updateQuantityInCart(cart, product, quantity);
		} 
		else 
		{
			System.out.println("!!!!!!!!!!!! insert !!!!!!!!!!!!!");
			insertIntoCartLine(cart, product, quantity);
		}
		
		
		
//		for (CartLine c : cartLines) {
//			if(product.getId() == c.getProduct().getId()) {
//				c.setQuantity(c.getQuantity() + quantity);
//				cart.setTotal(cart.getTotal() + product.getPrice());
//				c.setCart(cart);
//				
//				this.cartLineRepository.save(c);
//				this.cartRepository.save(cart);
//				return;
//			}
//		}
		
	}
	
	private void updateQuantityInCart(Cart cart, Product product, int quantity) {
		List<CartLine> cartLines = cart.getCartLines();
		
		cartLines.stream()
		.filter((c)-> c.getProduct().getId() == product.getId())
		.forEach(c -> {
			c.setQuantity(c.getQuantity() + quantity);
			cart.setTotal(cart.getTotal() + product.getPrice());
			c.setCart(cart);
			this.cartLineRepository.save(c);
			this.cartRepository.save(cart);
	});
	}
	
	private void insertIntoCartLine(Cart cart, Product product, int quantity) {
		CartLine newCarLine = new CartLine();
		newCarLine.setProduct(product);
		newCarLine.setQuantity(quantity);
		newCarLine.setCart(cart);
		cart.setTotal(cart.getTotal() + product.getPrice());
		this.cartLineRepository.save(newCarLine);
		this.cartRepository.save(cart);
	}

	@Override
	public CartLine addCartLine(long id) {
		return this.cartLineRepository.save(new CartLine(id,5));
	}

	@Override
	public List<Cart> getCarts() {
		return this.cartRepository.findAll();
	}
}
