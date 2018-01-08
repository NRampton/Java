package com.codingdojo.nrampton.zookeper;

public class Dragon extends Mammal {
	public Dragon() {
		this.energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("Whooosh!");
		this.changeEnergy(-50);
	}
	
	public void eatHumans() {
		System.out.println("It's a buncha muncha cruncha human.");
		this.changeEnergy(25);
	}
	
	public void attackTown() {
		System.out.println("You hear the sounds of crackling rafters and the weeping of the unhomed. Pansies.");
		this.changeEnergy(-100);
	}
}
