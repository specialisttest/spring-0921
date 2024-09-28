package ru.specialist.building;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component // id == brick
//@MyBean
//@Scope("prototype")
//@Primary
public class Brick implements Material {
	
	private String color;
	
	public String getColor() {
		return color;
	}
	//@Value("grey")
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void buildUp() {
		System.out.printf("Build up wall using brick colored %s\n", getColor());
		
	}

}
