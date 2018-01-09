package com.codingdojo.nrampton.pokemon;

public interface PokeFace {
	public static Pokemon createPokemon(String name, int health, String type) {
		return new Pokemon(name, health, type);
	}
	public static void attackPokemon(Pokemon target) {
		int targetHealth = target.getHealth();
		targetHealth -= 10;
		target.setHealth(targetHealth);
	}
	public static String[] pokemonInfo(Pokemon subject) {
		String[] info;
		info = new String[3];
		info[0] = subject.getName();
		info[1] = String.valueOf(subject.getHealth());
		info[2] = subject.getType();
		return info;
	}
}
