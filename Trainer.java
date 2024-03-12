package projecto_final_2021_B;

import java.util.List;

public interface Trainer {

	public abstract void addPokemonToTeam(Pokemon pokemon);
	public abstract boolean teamFainted();
	public abstract List<Pokemon> getTeam();
	
}
