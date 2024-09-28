package ru.specialist.building;

import org.springframework.stereotype.Component;

@Component("log")
public class Wood implements Material {

	@Override
	public void buildUp() {
		System.out.println("Build up wall using logs");
	}
	

}
