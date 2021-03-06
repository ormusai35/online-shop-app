package serverapp.onlineshop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cart")
public class Cart implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	@Column(name = "cart_id")
	private Long cartId;
	
	@OneToOne
	private User user;
	
//	@Transient
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
	@Column(name = "cart_lines")
	private List<CartLine> cartLines;

	@Column(name = "total")
	private double total;
	
	public Cart() {
		this.cartLines = new ArrayList<CartLine>(); 
	}
	
	public Cart(User user) {
		this.user = user;
		this.cartLines = new ArrayList<CartLine>();
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
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", user=" + user + ", cartLines=" + cartLines + ", total=" + total + "]";
	}
	
}