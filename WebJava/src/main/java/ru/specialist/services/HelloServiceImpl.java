package ru.specialist.services;

import java.time.LocalTime;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

	@Autowired
	private MessageSource messageSource;

	@Override
	public String getHello(String name) {
		
		String helloKey = null;
		LocalTime time = LocalTime.now();
		int h = time.getHour();
		
		if (h>=6 && h <12)
			helloKey = "day6_12";
		if (h>=12 && h <18)
			helloKey = "day12_18";
		if (h>=18 && h <=23)
			helloKey = "day18_24";
		if (h>=0 && h < 6)
			helloKey = "day0_6";
		
		String hello = messageSource.getMessage(helloKey, null, Locale.getDefault());
		
		return (name == null || name.isEmpty()) ? hello:
			String.format("%s, %s!", hello, name);
		
		
	}
	
}
