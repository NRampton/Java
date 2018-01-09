package com.codingdojo.nrampton.pokemon;

public abstract class Pokestract implements PokeFace {
	public Pokemon createPokemon(String name, int health, String type) {
		return PokeFace.createPokemon(name, health, type);
	}
	public void attackPokemon(Pokemon target) {
		PokeFace.attackPokemon(target);
	}
}
