package com.codingdojo.nrampton.objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		Human gus = new Human("Gus");
		Human herb = new Human("Herb");
		gus.attack(herb);
		herb.displayHealth();

	}

}
