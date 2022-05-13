package serverapp.onlineshop.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cart_line")
public class CartLine implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@GeneratedValue
	@Id
	@Column(name="line_id")
	private Long lineId;

	@ManyToOne
	@JoinColumn(name="cart_id")
	@JsonIgnore
	private Cart cart;
	
	@OneToOne
	private Product product;

	@Column(name = "quantity")
    private int quantity;
    
    public CartLine() {}

    public CartLine(long lineId,int quantity) {
    	this.lineId = lineId;
    	this.quantity = quantity;
    }
    
	public Long getLineId() {
		return lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

    public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartLine [lineId=" + lineId + ", cart=" + cart + ", product=" + product + ", quantity="
				+ quantity + "]";
	}
}
