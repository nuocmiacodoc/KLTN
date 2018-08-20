package com.packt.webstore.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.packt.webstore.domain.User;
import com.packt.webstore.service.UserService;

@Component
public class UserValidator  implements Validator{

    @Autowired
    private UserService userService;
    
	@Override
	public boolean supports(Class<?> aClass) {
		// TODO Auto-generated method stub
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		// TODO Auto-generated method stub
	       User user = (User) o;

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
	        if (user.getName().length() < 6 || user.getName().length() > 32) {
	            errors.rejectValue("name", "user.register.Id.Errors.message");
	        }
	        if (userService.findByUsername(user.getName()) != null) {
	            errors.rejectValue("name", "user.register.Id.Duplicate.message");
	        }

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
	        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
	            errors.rejectValue("password", "user.register.Password.Errors.message");
	        }

	        if (!user.getPasswordConfirm().equals(user.getPassword())) {
	            errors.rejectValue("passwordConfirm", "user.register.Password.Confirm.message");
	        }
	}

}
