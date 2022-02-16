package serverapp.onlineshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import serverapp.onlineshop.exception.UserNotFoundException;
import serverapp.onlineshop.model.User;
import serverapp.onlineshop.service.UserService;

@CrossOrigin(origins="http://localhost:4200/")
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

	@GetMapping(path="log-user")
	public ResponseEntity<User> loginUser(@RequestParam String email, @RequestParam String password) {
		try {			
			return new ResponseEntity<User>(this.userService.checkPassword(email,password),HttpStatus.OK);
		} catch(Exception  e) {
			return new ResponseEntity<User>(this.userService.checkPassword(email,password),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(path = "user-sign-up")
	public ResponseEntity<User> signUp(@RequestBody User user) {
		try {
			return ResponseEntity.ok(this.userService.insertUser(user));
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public String handleNotFoundUserException(Model model, UserNotFoundException exception, HttpServletRequest request) {
		model.addAttribute("exception", exception);
		model.addAttribute("url", request.getRequestURL());
		
		return exception.getMessage();
	}
}
