package projecto_final_2021_B;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class EventPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlayerTrainer trainer;
	private AITrainer aiTrainer;
	public  JLabel battleText = new JLabel();

	public EventPanel(PlayerTrainer trainer, AITrainer aiTrainer) {
		this.trainer = trainer;
		this.aiTrainer= aiTrainer;
	}
	
	public void refresh() {
		removeAll();
		UIManager.put("ProgressBar.background", Color.BLACK);
		UIManager.put("ProgressBar.foreground", Color.GREEN);
		UIManager.put("ProgressBar.selectionBackground", Color.RED);
		UIManager.put("ProgressBar.selectionForeground", Color.WHITE);
		setLayout(new BorderLayout());
		battleText.setHorizontalAlignment(SwingConstants.CENTER);
		battleText.setFont(new Font("BigNoodleTitling", Font.PLAIN, 20));
		add(battleText, BorderLayout.NORTH);
		JPanel pokemons = new JPanel();
		pokemons.setLayout(new GridLayout(1,2));
		pokemons.add(new JLabel(new ImageIcon(trainer.getActivePokemon().spritePath)));
		pokemons.add(new JLabel(new ImageIcon(aiTrainer.getActivePokemon().spritePath)));
		pokemons.setOpaque(false);
		add(pokemons, BorderLayout.CENTER);
		
		JPanel hp = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints(); 
		
		JProgressBar hpTrainer = new JProgressBar(0, trainer.getActivePokemon().maxHP);
		hpTrainer.setValue(trainer.getActivePokemon().getHp());
		hpTrainer.setStringPainted(true);
		hpTrainer.setString(String.valueOf(trainer.getActivePokemon().getHp()));
		gbc.insets = new Insets(0, 10, 10, 10);
	    gbc.fill = GridBagConstraints.HORIZONTAL;  
	    gbc.gridx = 0;  
	    gbc.gridy = 1;
	    hp.add(hpTrainer, gbc);

	    
		JProgressBar hpAITrainer = new JProgressBar(0, aiTrainer.getActivePokemon().maxHP);
		hpAITrainer.setValue(aiTrainer.getActivePokemon().getHp());
		hpAITrainer.setStringPainted(true);
		hpAITrainer.setString(String.valueOf(aiTrainer.getActivePokemon().getHp()));
		gbc.fill = GridBagConstraints.HORIZONTAL; 
	    gbc.gridx = 1;  
	    gbc.gridy = 1;
		hp.add(hpAITrainer, gbc);
		
		JLabel trainerPokemonName;
		if(trainer.getActivePokemon().getStatus() != StatusType.DEFAULT)
			trainerPokemonName = new JLabel(trainer.getActivePokemon().name + " | " + trainer.getActivePokemon().getStatus().toString());
		else
			trainerPokemonName = new JLabel(trainer.getActivePokemon().name);
		trainerPokemonName.setFont(new Font("BigNoodleTitling", Font.PLAIN, 18));
		gbc.insets = new Insets(50, 50, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL; 
	    gbc.gridx = 0;  
	    gbc.gridy = 0;
	    hp.add(trainerPokemonName);
	    
		JLabel aiTrainerPokemonName;
		if(aiTrainer.getActivePokemon().getStatus() != StatusType.DEFAULT)
			aiTrainerPokemonName = new JLabel(aiTrainer.getActivePokemon().name + " | " + aiTrainer.getActivePokemon().getStatus().toString());
		else
			aiTrainerPokemonName = new JLabel(aiTrainer.getActivePokemon().name);
		aiTrainerPokemonName.setFont(new Font("BigNoodleTitling", Font.PLAIN, 18));
		gbc.fill = GridBagConstraints.HORIZONTAL; 
	    gbc.gridx = 1;  
	    gbc.gridy = 0;
	    hp.add(aiTrainerPokemonName);
	    hp.setOpaque(false);
	    
	    
	    
		

		add(hp,BorderLayout.SOUTH);
		setOpaque(false);
		invalidate();
		validate();
		repaint();
	}


}
