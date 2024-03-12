package projecto_final_2021_B;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


import javax.swing.JPanel;

public class PokemonPoolPanel extends JPanel {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private List<Pokemon> pokemonList;
	private PlayerTrainer trainer;

	public PokemonPoolPanel(PlayerTrainer trainer, List<Pokemon> pokemonList){
		this.pokemonList = pokemonList;
		this.trainer = trainer;
		setLayout(new GridLayout(5,2, 30, 30));
	}
	
	public void buildPanel() {
		for(Pokemon pokemon : pokemonList) {
			PokemonLabel pokemonLabel = new PokemonLabel(pokemon, trainer);
			pokemonLabel.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	pokemonLabel.addPokemon();
	            	pokemonLabel.enabled = !pokemonLabel.enabled;
	            }
	        });
			add(pokemonLabel);
		}
	}
	
}
