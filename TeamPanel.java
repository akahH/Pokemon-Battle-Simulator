package projecto_final_2021_B;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class TeamPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TeamPanel(PlayerTrainer trainer) {
		GridLayout grid = new GridLayout(3,1, 10, 10);
		setLayout(grid);
		for(Pokemon pokemon : trainer.getTeam()) {
			pokemon.print();
			add(new PokemonLabel(pokemon, trainer));
		}
	}
	
	public TeamPanel(AITrainer aiTrainer) {

			GridLayout grid = new GridLayout(3,1, 10, 10);
			setLayout(grid);
			System.out.println(aiTrainer.getTeam().size());
			for(Pokemon pokemon : aiTrainer.getTeam()) {
				pokemon.print();
				add(new PokemonLabel(pokemon));
			}
		}
	
	public void refresh(PlayerTrainer trainer) {
		removeAll();
		GridLayout grid = new GridLayout(3,1, 10, 10);
		setLayout(grid);
		for(Pokemon pokemon : trainer.getTeam()) {
			pokemon.print();
			PokemonLabel label = new PokemonLabel(pokemon, trainer);
			add(label);
			if(pokemon.isFainted())
				label.setEnabled(false);
		}
		invalidate();
		validate();
		repaint();
	}
	
	public void refresh(AITrainer trainer) {
		removeAll();
		GridLayout grid = new GridLayout(3,1, 10, 10);
		setLayout(grid);
		System.out.println(trainer.getTeam().size());
		for(Pokemon pokemon : trainer.getTeam()) {
			pokemon.print();
			PokemonLabel label = new PokemonLabel(pokemon);
			add(label);
			if(pokemon.isFainted())
				label.setEnabled(false);
		}
		invalidate();
		validate();
		repaint();
	}

}
