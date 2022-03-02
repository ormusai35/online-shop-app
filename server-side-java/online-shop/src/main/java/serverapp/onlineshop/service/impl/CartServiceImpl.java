package serverapp.onlineshop.service.impl;

import java.util.Collection;
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
		return this.cartRepository.getById(cartId);
	}

	@Override
	public CartLine updateCart(long cartId, Product product, int quantity) {
		List<CartLine> lines = this.cartLineRepository.findCartLineByCartId(cartId);
		lines.stream().forEach(l -> System.out.println(l));
		System.out.println(lines.iterator().next());
//		for (CartLine line : lines) {
//			if(line.getProduct().getId() == product.getId()) {
//				line.setProductCount(line.getProductCount() + quantity);
//				this.cartLineRepository.save(line);
//				return line;
//			}
//		}
		return new CartLine();
//		return createCartLine(cartId, product, quantity);
	}
	
	private CartLine createCartLine(long cartId, Product product, int quantity) {
		Cart cart = this.cartRepository.getById(cartId);
		CartLine newCarLine = new CartLine();
		newCarLine.setCart(cart);
		newCarLine.setProduct(product);
		newCarLine.setProductCount(quantity);
		return this.cartLineRepository.save(newCarLine);
	}

	


}
