package ru.specialist.building;

import jakarta.annotation.PreDestroy;

public class WoodDoor implements Door {

	@Override
	public void install() {
		System.out.println("Intall wood door");
	}
	
	@PreDestroy // не работает для scope == "prototype"
	public void onDestroy() {
		System.out.println("On wood door destroy");
	}

}
