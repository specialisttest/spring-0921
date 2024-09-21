package ru.specialist;

public class App {

	public static void main(String[] args) {
//		//House house = new House();
//		PlasticWindow window = new PlasticWindow();
//		WoodWindow window2 = new WoodWindow();
//		House house = new House(window);
		//house.setWindow(window2);
		
//		house.ventilate();
		
		try (var builder = new Builder())
		{
			builder.myHouse().ventilate();
		}
		

	}

}
