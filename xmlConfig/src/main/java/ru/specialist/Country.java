package ru.specialist;

import java.util.List;

public class Country {
	private String title;
	private List<City> cities;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}	

}
