package serverapp.onlineshop.service;

import java.util.List;

import serverapp.onlineshop.model.User;

public interface UserService {
	
	List<User> getUsers();
	
	User getUserById(long userId);

	User checkPassword(String email, String password);

	User insertUser(User user);
}
