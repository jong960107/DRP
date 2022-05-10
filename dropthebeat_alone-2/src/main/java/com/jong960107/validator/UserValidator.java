package com.jong960107.validator;

import java.util.Set;



import javax.validation.ConstraintViolation;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jong960107.beans.UserInfo;

@PropertySource(value = "classpath:/dropthebeat_alone-2/src/main/resources/messages.properties", encoding="UTF-8")
public class UserValidator implements Validator{

	
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserInfo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UserInfo userBean = (UserInfo)target;
		
		
		if(userBean.getUser_pw().equals(userBean.getUser_pw2())==false) {
			errors.rejectValue("user_pw","NotEquals");
			errors.rejectValue("user_pw2","NotEquals2");
		}
		
		if(userBean.isUserIdExist() == false) {
			errors.rejectValue("user_id", "DontCheckUserIdExist");
		}
		
	}



	
	
	
}
