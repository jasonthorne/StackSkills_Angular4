package com.android.animals;

public class Zebra extends Animal{

	String name;
	
	//constructor:
	public Zebra(){
		System.out.println("Zebra created");
	}
	
	
	@Override 
	public void eat() {
		System.out.println("Zebra eating");
	}
	
	@Override 
	public void sleep() {
		System.out.println("Zebra sleeping");
	}

}
