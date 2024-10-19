package ru.specialist.models;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component("userVM")
public class UserVM {
	
	// Properties: userName, hello (read only)
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String getHello() {
		return (getUserName() == null || getUserName().isEmpty()) ? "Привет!" : 
			String.format("Привет, %s!", getUserName());
	}	
	
	/*@Autowired
	private MessageSource messageSource;

	public String getHello() {
		
		String hello = messageSource.getMessage("header_hello", null, Locale.US);
		
		return (getUserName() == null || getUserName().isEmpty() ? hello :
			messageSource.getMessage("header_hello_username", 
					new Object[] {getUserName()}, Locale.getDefault()));
		
	}*/
	
	
}
