package ru.specialist;

import java.io.Closeable;
import java.io.IOException;
import java.util.Locale;

public class Builder implements Closeable {
	
	public Window createWoodWindow() {
		return new WoodWindow();
	}
	
	public Window createPlasticWindow() {
		return new PlasticWindow();
	}
	
	public Window createDefaultWindow() {
		if (Locale.getDefault().getCountry().equals("RU"))
			return createWoodWindow();
		else 
			return createPlasticWindow();
	}
	
	
	private House house;
	public House myHouse() {
		if (house == null)
			house = new House(createDefaultWindow()); // di 
		return house;
		
	}

	@Override
	public void close() {
		if (house != null)
			System.out.printf("Destroy house: %s\n", house);
		
	}
	

}
