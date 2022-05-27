package serverapp.onlineshop.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import serverapp.onlineshop.model.User;

@Component
public class PasswordValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		if(user.getPassword().length()<2 || user.getPassword().length()>10){
			errors.rejectValue("password", null, "Password must be between 2 and 10 character");
		}
	}

}
