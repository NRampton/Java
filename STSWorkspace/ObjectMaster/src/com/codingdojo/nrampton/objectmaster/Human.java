package com.codingdojo.nrampton.objectmaster;

public class Human {
	//attributes
	private String name;
	private int health;
	private int strength;
	private int stealth;
	private int intelligence;
	
	//constructor
	public Human(String name) {
		this.name = name;
		this.health = 100;
		this.strength = 3;
		this.stealth = 3;
		this.intelligence = 3;
	}
	
	//instance methods
	public void attack(Human target) {
		System.out.println("Rawr! " + this.name + " is attacking " + target.name + "!");
		target.changeHealth(-this.strength);
	}
	
	public void changeHealth(int delta) {
		this.health += delta;
	}
	
	public void displayHealth() {
		System.out.println(this.name + "'s current health: " + this.health);
	}
}
