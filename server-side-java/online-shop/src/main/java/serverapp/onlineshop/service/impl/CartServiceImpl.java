package serverapp.onlineshop.service.impl;

import java.util.ArrayList;
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
		return this.cartRepository.findByCartId(cartId);
	}

	@Override
	public Cart updateCart(Cart cart, Product product, int quantity) {
		
		List<CartLine> cartLines = cart.getCartLines();
		System.out.println(cartLines);
		for (CartLine c : cartLines) {
			if(product.getId() == c.getProduct().getId()) {
				c.setQuantity(c.getQuantity() + quantity);
				cart.setTotal(cart.getTotal() + product.getPrice());
//				cart.setCartLines(cartLines);
				return cart;
			}
		}
		
		insertIntoCartLine(cart, product, quantity);
		return cart;
		
	}
	
	private void insertIntoCartLine(Cart cart, Product product, int quantity) {
		CartLine newCarLine = new CartLine();
		newCarLine.setProduct(product);
		newCarLine.setQuantity(quantity);
		newCarLine.setCart(cart);
		cart.setTotal(cart.getTotal() + product.getPrice());
		this.cartLineRepository.save(newCarLine);
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





//List<CartLine> lines = this.cartLineRepository.findCartLineByCartId(cartId);
//List<CartLine> lines = this.cartLineRepository.findCartLineByQuantity(5);
//ArrayList<CartLine> lines = this.cartLineRepository.findByQuantity(0);
//CartLine c = this.cartLineRepository.getById(1L);

//for (CartLine line : lines) {
//	if(line.getProduct().getId() == product.getId()) {
//		line.setProductCount(line.getProductCount() + quantity);
//		this.cartLineRepository.save(line);
//		return line;
//	}
//	System.out.println(line);
//}
//return new CartLine();
//return createCartLine(cartId, product, quantity);
