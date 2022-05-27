package serverapp.onlineshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import serverapp.onlineshop.exception.UserAlreadyExistsException;
import serverapp.onlineshop.model.User;
import serverapp.onlineshop.repository.UserRepository;
import serverapp.onlineshop.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public User checkPassword(String email, String password){
		User user = this.userRepository.findByEmail(email);
		if (user != null && user.getPassword().equals(password)) return user;
		else return null;
	}
	
	@Override
	public User insertUser(User user) throws UserAlreadyExistsException {
		if(this.userRepository.existsByEmail(user.getEmail()))
			throw new UserAlreadyExistsException("User Email Already exists!");
		else 
			return this.userRepository.save(user);
	}

	@Override
	public User getUserById(long userId) {
		if(this.userRepository.existsById(userId)) 
			return this.userRepository.findById(userId).get();
		else return null;
	}

	@Override
	public User updateUser(User user) {
		return this.userRepository.save(user);
	}
}
