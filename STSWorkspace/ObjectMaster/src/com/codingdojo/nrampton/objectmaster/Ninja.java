package com.codingdojo.nrampton.objectmaster;

public class Ninja extends Human {

	public Ninja(String name) {
		super(name);
		this.stealth = 10;		
	}
	
	public void steal(Human target) {
		target.changeHealth(-this.stealth);
		this.changeHealth(this.stealth);
	}
	
	public void runAway() {
		this.changeHealth(-10);
	}
	
	
}
