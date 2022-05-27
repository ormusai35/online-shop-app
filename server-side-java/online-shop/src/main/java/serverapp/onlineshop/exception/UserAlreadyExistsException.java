package serverapp.onlineshop.exception;

public class UserAlreadyExistsException extends RuntimeException{
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserAlreadyExistsException(String message) {
		this.message = message;
	}
	
}
