package ru.specialist;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PlasticWindow implements Window {
	
	public void open() {
		System.out.println("Open plastic window");
	}

}
