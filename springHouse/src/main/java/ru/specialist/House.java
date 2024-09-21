package ru.specialist;

public class House {
	
	private Window window;
	
	public House() {}
	
	public House(Window window) {
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
