package ru.specialist.building;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("logs")
@Scope("prototype")
public class Wood implements Material {

	@Override
	public void buildUp() {
		System.out.println("Build up wall using logs");
	}
	

}
