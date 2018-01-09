package com.codingdojo.nrampton.pokemon;

import java.util.Arrays;

public class PokedexTest {
	public static void main(String[] args) {
		Pokedex pokedex = new Pokedex();
		Pokemon wartotle = pokedex.createPokemon("Wartotle", 100, "Water");
		System.out.println(Arrays.toString(pokedex.pokemonInfo(wartotle)));
		Pokemon sandslash = pokedex.createPokemon("Sandslash", 100, "Ground");
		pokedex.attackPokemon(sandslash);
		System.out.println(Arrays.toString(pokedex.pokemonInfo(sandslash)));
	}
}
