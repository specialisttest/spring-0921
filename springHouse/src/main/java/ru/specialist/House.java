package ru.specialist;

import org.springframework.beans.factory.annotation.Value;

public class House {
	
	private Window window;
	
	public House() {}
	
	public House(/*@Value("#{plasticWindow}")*/ Window window) {
		this.window = window;
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}
	
	public void ventilate() {
		getWindow().open();
	}
	

}
