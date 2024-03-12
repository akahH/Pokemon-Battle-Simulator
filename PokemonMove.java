package projecto_final_2021_B;

public interface  PokemonMove {

	public void execute(Pokemon source, Pokemon target);
	
	public String getName();
	
	public int getPowerPoints();

}
