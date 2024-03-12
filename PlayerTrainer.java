package projecto_final_2021_B;

import java.util.ArrayList;
import java.util.List;

public class PlayerTrainer implements Trainer {
	
	private List<Pokemon> pokemonTeam = new ArrayList<Pokemon>();
	private Pokemon activePokemon;

	
	public void chooseActivePokemon(int pokemonIndex) {

		activePokemon = pokemonTeam.get(pokemonIndex);
	}

	public void chooseActivePokemon(Pokemon pokemon) {

		activePokemon = pokemonTeam.get(pokemonTeam.indexOf(pokemon));
	}
	
	public Pokemon getActivePokemon() {
		return activePokemon;
	}

	public PokemonMove chooseMove(int moveIndex) {
		
		return activePokemon.moves.get(moveIndex);
	}

	@Override
	public void addPokemonToTeam(Pokemon pokemon) {
		
		pokemonTeam.add(pokemon);
	}

	@Override
	public boolean teamFainted() {
		boolean fainted = true;
		for(Pokemon pokemon : pokemonTeam) {
			if(pokemon.getHp() > 0)
				fainted = false;
		}
		return fainted;
	}

	@Override
	public List<Pokemon> getTeam() {
		return pokemonTeam;
	}
	
	public void printTeam() {
		System.out.println("Choose a Pokemon: ");
		for(Pokemon pokemon : pokemonTeam) {
			if(!pokemon.isFainted()) {
				System.out.println(pokemonTeam.indexOf(pokemon)+ " " + pokemon.name);
			}
		}
	}




}
