package projecto_final_2021_B;

import java.util.ArrayList;
import java.util.List;

public class AITrainer implements Trainer {
	
	private List<Pokemon> pokemonTeam = new ArrayList<Pokemon>();
	private Pokemon activePokemon;

	
	public void chooseActivePokemon() {
		int pokemonIndex = (int) (Math.random() * (3));
		if(pokemonTeam.get(pokemonIndex).isFainted())
			chooseActivePokemon();
		else
			activePokemon = pokemonTeam.get(pokemonIndex);
	}

	public Pokemon getActivePokemon() {
		return activePokemon;
	}


	public PokemonMove chooseMove() {	
		int moveIndex = (int) (Math.random() * (4));
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
	


}
