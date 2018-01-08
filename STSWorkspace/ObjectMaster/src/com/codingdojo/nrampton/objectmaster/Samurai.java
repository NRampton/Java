package com.codingdojo.nrampton.objectmaster;

public class Samurai extends Human {

	private static int count = 0;
	
	public Samurai(String name) {
		super(name);
		this.health = 200;
		count++;
	}
	
	public void deathBlow(Human target) {
		target.health = 0;
		this.changeHealth(-this.health / 2);
	}
	
	public void meditate() {
		this.changeHealth(this.health / 2);
	}
	
	public int howMany() {
		return count;
	}

}
