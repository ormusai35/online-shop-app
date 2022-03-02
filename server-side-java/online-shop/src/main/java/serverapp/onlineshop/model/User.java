package serverapp.onlineshop.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	@Id
	@GeneratedValue
	@Column(name = "id") 
	private long id;
	
	@Column(name = "user_name") 
	private String userName;
	
	@Column(name = "email") 
	private String email;
	
	@Column(name = "password") 
	private String password;
	
	@Column(name = "is_admin") 
	private boolean isAdmin;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	

	@Temporal(TemporalType.TIMESTAMP)
//	@Column(nullable = false)
	private Date timestamp;
	
	public long getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public boolean getIsAdmin() {
		return isAdmin;
	}
	public Date getTimestamp() {
		return timestamp;
	}

	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	@PrePersist
	private void onCreate() {
	    timestamp = new Date();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", isAdmin=" + isAdmin + "]";
	}
}
