package serverapp.onlineshop.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart{
	
	@GeneratedValue
	@Id
	@Column(name = "cart_id")
	private Long cartId;
	
	@OneToOne
	private User user;
	
	@OneToMany(mappedBy = "cart")
	@Column(name = "cart_lines")
	private List<CartLine> cartLines;

	@Column(name = "total_price")
	private double totalPrice;
	
	public Cart() {}
	
	public Cart(User user) {
		this.user = user;
	}
	
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<CartLine> getCartLines() {
		return cartLines;
	}
	public void setCartLines(List<CartLine> cartLines) {
		this.cartLines = cartLines;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}