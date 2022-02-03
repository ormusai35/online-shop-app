package serverapp.onlineshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import serverapp.onlineshop.model.User;
import serverapp.onlineshop.service.UserService;


@CrossOrigin(origins="http://localhost:4200")
@RestController 
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(path="get-users")
	public List<User> getHello() {
		return this.userService.getUsers();
	}
	
}
