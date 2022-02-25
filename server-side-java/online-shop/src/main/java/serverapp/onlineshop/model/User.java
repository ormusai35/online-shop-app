package serverapp.onlineshop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User {
	
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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
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
