package ru.specialist.lab11;

public class Person {
	private String name;
	private int age;
	
	public Person() {}
	
	public Person(String name, int age) {
		System.out.println("ctor Person");
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %d", getName(), getAge());
	}

}
