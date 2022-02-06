package serverapp.onlineshop.controller;

import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import serverapp.onlineshop.exception.UserAlreadyExistsException;
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
	
	@GetMapping(path = "/login")
	public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password){
		try {			
//			return ResponseEntity.ok(this.userService.checkPassword(email,password));
			return new ResponseEntity<User>(this.userService.checkPassword(email,password),HttpStatus.OK);
		} catch(Exception  e) {
			return new ResponseEntity<User>(this.userService.checkPassword(email,password),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(path = "sign-up")
	public ResponseEntity<User> signUp(@RequestBody User user) {
		try {
			return ResponseEntity.ok(this.userService.insertUser(user));
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping(path="test")
	public ResponseEntity<Message> test() {
		try {
			return new ResponseEntity<Message>(new Message(),HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Message>(new Message(),HttpStatus.BAD_REQUEST);
		}
	}
}
