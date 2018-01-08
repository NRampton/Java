package com.codingdojo.nrampton.zookeper;

public class Mammal {
	protected int energyLevel;
	public Mammal() {
		this.energyLevel = 100;
	}
	public int displayEnergy() {
		System.out.println(this.energyLevel);
		return this.energyLevel;
	}
	public void changeEnergy(int delta) {
		this.energyLevel += delta;
	}
}