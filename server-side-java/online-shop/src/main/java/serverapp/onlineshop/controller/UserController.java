package serverapp.onlineshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import serverapp.onlineshop.exception.UserAlreadyExistsException;
import serverapp.onlineshop.exception.UserNotFoundException;
import serverapp.onlineshop.model.User;
import serverapp.onlineshop.service.UserService;
import serverapp.onlineshop.validator.PasswordValidator;

@CrossOrigin(origins="http://localhost:4200/")
@RestController 
public class UserController {
	
	private static Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	private UserService userService;
	
	@Autowired
	private PasswordValidator passwordValidator;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(path="get-users")
	public List<User> getUsers() {
//		LOG.error("All users");
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
	public ResponseEntity<User> signUp(@Validated @RequestBody User user) {
		return ResponseEntity.ok(this.userService.insertUser(user));
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println();
		binder.addValidators(passwordValidator);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handleNotFoundUserException(Model model, RuntimeException exception, HttpServletRequest request) {
		return ExceptionExecutor(model,exception,request);
	}
	
//	@ExceptionHandler(UserAlreadyExistsException.class)
//	public String handleUserAlradyExistsException(Model model, RuntimeException exception, HttpServletRequest request) {
//		return ExceptionExecutor(model,exception,request);
//	}
	
	private String ExceptionExecutor(Model model, RuntimeException exception, HttpServletRequest request) {
		model.addAttribute("exception", exception);
		model.addAttribute("url", request.getRequestURL());
		return exception.getMessage(); 
	}
}
