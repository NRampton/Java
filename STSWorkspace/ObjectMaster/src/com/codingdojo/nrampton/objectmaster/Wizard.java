package com.codingdojo.nrampton.objectmaster;

public class Wizard extends Human {

	public Wizard(String name) {
		super(name);
		this.health = 50;
		this.intelligence = 8;
	}
	
	public void heal(Human target) {
		target.changeHealth(this.intelligence);
	}
	
	public void fireball(Human target) {
		target.changeHealth(this.intelligence * -3);
	}
}
