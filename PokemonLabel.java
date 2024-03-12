package projecto_final_2021_B;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class PokemonLabel extends JLabel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Pokemon pokemon;
	private PlayerTrainer trainer;
	public boolean  enabled = true;

	public PokemonLabel(Pokemon pokemon, PlayerTrainer trainer) {
		this.pokemon = pokemon;
		this.name = pokemon.name;
		this.trainer = trainer;
		setIcon(new ImageIcon(pokemon.iconPath));
		String types = "";
		for(PokemonType pokemonType: pokemon.types)
			types+= " " + pokemonType.toString();
		setText(name + " / " + types);
		setFont(new Font("BigNoodleTitling", Font.PLAIN, 18));
		setOpaque(true);
		setBackground(getColor(pokemon.types.get(0)));
        setHorizontalAlignment(SwingConstants.LEFT);
        setVerticalAlignment(SwingConstants.CENTER);
        
	}
	
	public PokemonLabel(Pokemon pokemon) {
		this.pokemon = pokemon;
		this.name = pokemon.name;
		setIcon(new ImageIcon(pokemon.iconPath));
		String types = "";
		for(PokemonType pokemonType: pokemon.types)
			types+= " " + pokemonType.toString();
		setText(name + " / " + types);
		setFont(new Font("BigNoodleTitling", Font.PLAIN, 18));
		setOpaque(true);
		setBackground(getColor(pokemon.types.get(0)));
        setHorizontalAlignment(SwingConstants.LEFT);
        setVerticalAlignment(SwingConstants.CENTER);
        
	}
	
	
	public void addPokemon() {
		if(trainer.getTeam().size() < 3 && enabled == true ) {
        	trainer.addPokemonToTeam(pokemon);
        	setBackground(Color.GRAY);
        	Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        	setBorder(border);
          	trainer.printTeam();
        	
    	}
    	if(enabled == false) {
    		trainer.getTeam().remove(pokemon);
    		setBackground(getColor(pokemon.types.get(0)));
    		setBorder(null);
    		trainer.printTeam();

    	}
	}
	
	private Color getColor(PokemonType type) {
		switch(type) {
		case BUG:
			return new Color(189, 255, 0);
		case DARK:
			setForeground(Color.white);
			return new Color(0, 0, 0);
		case DRAGON:
			setForeground(Color.white);
			return new Color(126, 65,255);
		case ELECTRIC:
			return new Color(255, 213, 65);
		case FAIRY:
			return new Color(255, 201, 250);
		case FIGHTING:
			return new Color(255, 88, 88);
		case FIRE:
			return new Color(255, 181, 70);
		case FLYING:
			return new Color(168, 234, 255);
		case GHOST:
			return new Color(79, 78, 134);
		case GRASS:
			return new Color(48,255,131);
		case GROUND:
			return new Color(193, 122, 58);
		case ICE:
			return new Color(63, 255, 255);
		case NORMAL:
			return new Color(196, 196, 196);
		case POISON:
			return new Color(211, 60, 249);
		case PSYCHIC:
			return new Color(255,130, 190);
		case ROCK:
			return new Color(143, 109, 77);
		case STEEL:
			return new Color(169, 168, 168);
		case WATER:
			return new Color(78, 170, 255);
			
		}
		return null;
	}

}
