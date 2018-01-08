package com.codingdojo.nrampton.zookeper;

public class Gorilla extends Mammal {
	//constructor
	public Gorilla() {
		this.energyLevel = 100;
	}
	
	public void throwSomething() {
		System.out.println("The gorilla threw something. We won't mention what.");
		this.changeEnergy(-5);
	}
	
	public void eatBananas() {
		System.out.println("Yummy bananas...");
		this.changeEnergy(10);
	}
	
	public void climb() {
		System.out.println("Climbing some stuff!");
		this.changeEnergy(-10);
	}
}
