package projecto_final_2021_B;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class BattlePanel extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlayerTrainer trainer;
	private AITrainer aiTrainer;
	private CardLayout cardLayout;
	private JPanel container;
	private EventPanel eventPanel;
	private TeamPanel leftPanel;
	private TeamPanel rightPanel; 
	
	public BattlePanel(PlayerTrainer trainer, AITrainer aiTrainer, CardLayout layout, JPanel container ) throws IOException {
		
		this.trainer = trainer;
		this.aiTrainer = aiTrainer;
		this.cardLayout = layout;
		this.container = container;
		setLayout(new BorderLayout());
		leftPanel = new TeamPanel(trainer);
		rightPanel = new TeamPanel(aiTrainer);
		
		eventPanel = new EventPanel(this.trainer, this.aiTrainer);
		eventPanel.battleText.setText("<html><body style='text-align: center;'> You sent out " + trainer.getActivePokemon().name + 
				"<br>Opponent sent out " + aiTrainer.getActivePokemon().name + "</html></body>");
		eventPanel.refresh();
		eventPanel.setOpaque(false);
		
		
        leftPanel.setPreferredSize(new Dimension(300, 500));
        leftPanel.setOpaque(false);
		
		rightPanel.setPreferredSize(new Dimension(300, 500));
		rightPanel.setOpaque(false);
		
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridBagLayout());

        northPanel.setPreferredSize(new Dimension(800, 100));
        northPanel.setOpaque(false);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(800, 100));
        bottomPanel.setOpaque(false);
        
        setOpaque(false);
    	add(eventPanel, BorderLayout.CENTER);
		add(optionsPanel(), BorderLayout.SOUTH);
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);
		add(northPanel, BorderLayout.NORTH);
	}
	
	
	private JPanel optionsPanel() {
		CardLayout layout = new CardLayout();
		JPanel optionsContainer = new JPanel(new BorderLayout());
		optionsContainer.setOpaque(false);
		optionsContainer.setLayout(layout);
		
		
		JPanel borderContainer = new JPanel (new BorderLayout());
		borderContainer.setOpaque(false);
		JPanel options = new JPanel();
		options.setOpaque(false);
		options.setPreferredSize(new Dimension(800,100));
		options.setLayout(new GridLayout(2,2,10, 10));
		
		JButton newGame = new JButton("New Game");
		newGame.setBackground(new Color(242, 170, 107));
		newGame.setForeground(Color.white);
		newGame.setFont(new Font("BigNoodleTitling", Font.PLAIN, 18));
		newGame.addActionListener( new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				trainer.getTeam().clear();
				SelectionPanel selectionPanel = null;
				try {
					selectionPanel = new SelectionPanel(cardLayout, container);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				UI.clip.stop();
				UI.playSound("../music/selection_menu.wav");
				container.add(selectionPanel, "1");
				cardLayout.show(container, "1");
				
			}
		});
		
		JButton fight = new JButton("Fight");
		fight.setBackground(new Color(242, 170, 107));
		fight.setForeground(Color.white);
		fight.setFont(new Font("BigNoodleTitling", Font.PLAIN, 18));
		fight.addActionListener( new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
			
				optionsContainer.add(movesPanel(optionsContainer, layout), "2");
				layout.show(optionsContainer, "2");
				
			}
		});
		JButton changePokemon = new JButton("Change Pokémon");
		changePokemon.setBackground(new Color(242, 170, 107));
		changePokemon.setForeground(Color.white);
		changePokemon.setFont(new Font("BigNoodleTitling", Font.PLAIN, 18));
		changePokemon.addActionListener( new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
			
				optionsContainer.add(changePokemon(optionsContainer, layout), "3");
				layout.show(optionsContainer, "3");
				
			}
		});
		options.add(newGame);
		options.add(fight);
		options.add(changePokemon);
		

        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(800, 30));
        northPanel.setOpaque(false);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.setPreferredSize(new Dimension(800, 30));
		

		borderContainer.add(options, BorderLayout.CENTER);
		borderContainer.add(bottomPanel, BorderLayout.SOUTH);
		borderContainer.add(northPanel, BorderLayout.NORTH);
		
		optionsContainer.add(borderContainer, "1");
		
		layout.show(optionsContainer, "1");
		return optionsContainer;
		
	}
	
	private JPanel movesPanel(JPanel container, CardLayout layout) {
		JPanel borderContainer = new JPanel (new BorderLayout());
		borderContainer.setOpaque(false);
		JPanel movesPanel = new JPanel();
		movesPanel.setOpaque(false);
		movesPanel.setPreferredSize(new Dimension(800,100));
		List<PokemonMove> pokemonMoves = trainer.getActivePokemon().moves;
		movesPanel.setLayout(new GridLayout(2,2, 20,20));
		for(PokemonMove pokemonMove : pokemonMoves) {
			JButton move = new JButton(pokemonMove.getName());
			move.addActionListener( new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					fight(pokemonMove, layout, container);
					eventPanel.refresh();
					
				}
			});
			move.setFont(new Font("BigNoodleTitling", Font.PLAIN, 18));
			move.setBackground(new Color(242, 170, 107));
			move.setForeground(Color.white);
			movesPanel.add(move);
		}
		

        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(800, 30));
        northPanel.setOpaque(false);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(800, 30));
        bottomPanel.setOpaque(false);

		borderContainer.add(movesPanel, BorderLayout.CENTER);
		borderContainer.add(bottomPanel, BorderLayout.SOUTH);
		borderContainer.add(northPanel, BorderLayout.NORTH);
		return borderContainer;
	}

	private JPanel changePokemon(JPanel container, CardLayout layout) {
		
		JPanel borderContainer = new JPanel (new BorderLayout());
		borderContainer.setOpaque(false);
		JPanel changePokemon = new JPanel();
		changePokemon.setOpaque(false);
		changePokemon.setPreferredSize(new Dimension(800,100));
		List<Pokemon> trainerTeam = trainer.getTeam();
		changePokemon.setLayout(new GridLayout(2,2, 20,20));
		for(Pokemon pokemon : trainerTeam) {
			PokemonLabel pokemonLabel = new PokemonLabel(pokemon);


			if(pokemon.equals(trainer.getActivePokemon()) || pokemon.isFainted())
				pokemonLabel.setEnabled(false);
			else
				pokemonLabel.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		            	trainer.chooseActivePokemon(pokemon);
		            	eventPanel.refresh();
						layout.show(container, "1");
		            }
		        });
			
			changePokemon.add(pokemonLabel);
			
		}
		
		JButton goBack = new JButton("Return to Menu");
		goBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
				layout.show(container, "1");
            }
        });
		goBack.setFont(new Font("BigNoodleTitling", Font.PLAIN, 18));
		goBack.setBackground(new Color(242, 170, 107));
		goBack.setForeground(Color.white);
		changePokemon.add(goBack);
        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(800, 30));
        northPanel.setOpaque(false);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(800, 30));
        bottomPanel.setOpaque(false);


		borderContainer.add(changePokemon, BorderLayout.CENTER);
		borderContainer.add(bottomPanel, BorderLayout.SOUTH);
		borderContainer.add(northPanel, BorderLayout.NORTH);
		
		return borderContainer;
	}

	private void fight(PokemonMove move, CardLayout layout, JPanel optionsContainer) {

			Pokemon trainerPokemon = trainer.getActivePokemon();
			Pokemon aiTrainerPokemon = aiTrainer.getActivePokemon();
			
			PokemonMove trainerMove = move;
			PokemonMove aiTrainerMove = aiTrainer.chooseMove();
			
			boolean trainerPokemonCanMove = trainerPokemon.startStatusEffect();
			boolean aiTrainerPokemonCanMove = aiTrainerPokemon.startStatusEffect();
			
			String battleText = "<html><body style='text-align: center;'>";
			
			if(trainerPokemon.getSpeed() > aiTrainerPokemon.getSpeed()) {
				
				if(trainerPokemonCanMove)
					{
					System.out.println(trainer.getActivePokemon().name + " used " + trainerMove.getName());
					battleText += trainer.getActivePokemon().name + " used " + trainerMove.getName() + "<br>";
					trainerMove.execute(trainerPokemon, aiTrainerPokemon);
					}

				
				if(aiTrainerPokemon.isFainted()) {
					System.out.println(aiTrainerPokemon.name + " fainted");
					if(checkEnd())
						System.out.println("Battle is over");
					else {
						battleText += aiTrainer.getActivePokemon().name +  " has fainted";
						aiTrainer.chooseActivePokemon();
						eventPanel.refresh();
					}
						
				}
				else {
					System.out.println(aiTrainer.getActivePokemon().name + " used " + aiTrainerMove.getName());
					if(aiTrainerPokemonCanMove)
						{
						System.out.println(aiTrainer.getActivePokemon().name + " used " + aiTrainerMove.getName());
						battleText += aiTrainer.getActivePokemon().name + " used " + aiTrainerMove.getName() + "<br>";
						aiTrainerMove.execute(aiTrainerPokemon , trainerPokemon);
						}

					
					if(trainerPokemon.isFainted()) {
						System.out.println(trainerPokemon.name + " fainted");
						if(checkEnd())
							System.out.println("Battle is over");
						else
							{
							battleText += trainer.getActivePokemon().name + " has fainted";
							optionsContainer.add(changePokemon(optionsContainer, layout), "3");
							layout.show(optionsContainer, "3");
							}
							
					}
				}
			}
			
			else{
				
				if(aiTrainerPokemonCanMove)
					{
					System.out.println(aiTrainer.getActivePokemon().name + " used " + aiTrainerMove.getName());
					battleText += aiTrainer.getActivePokemon().name + " used " + aiTrainerMove.getName() + "<br>";
					aiTrainerMove.execute(aiTrainerPokemon , trainerPokemon);
					}

				
				if(trainerPokemon.isFainted()) {
					System.out.println(trainerPokemon.name + " fainted");
					if(checkEnd())
						System.out.println("Battle is over");
					else
						{
						battleText += trainer.getActivePokemon().name + " has fainted";
						optionsContainer.add(changePokemon(optionsContainer, layout), "3");
						layout.show(optionsContainer, "3");
						}
				}
				else {
					
					if(trainerPokemonCanMove)
						{
						System.out.println(trainer.getActivePokemon().name + " used " + trainerMove.getName());
						battleText += trainer.getActivePokemon().name + " used " + trainerMove.getName() + "<br>";
						trainerMove.execute(trainerPokemon, aiTrainerPokemon);
						
						}

					
					if(aiTrainerPokemon.isFainted()) {
						System.out.println(aiTrainerPokemon.name + " fainted");
						if(checkEnd())
							System.out.println("Battle is over");
						else {
							battleText += aiTrainer.getActivePokemon().name + " has fainted";
							aiTrainer.chooseActivePokemon();
							eventPanel.refresh();
						}
							
					}
				}
				
			}
		if(!checkEnd() && !trainerPokemon.isFainted())
			layout.show(optionsContainer, "1");
		if(checkEnd())
			{
			optionsContainer.add(endPanel(), "4");
			layout.show(optionsContainer, "4");
			}
		
		trainerPokemon.endStatusEffect();
		aiTrainerPokemon.endStatusEffect();
		battleText += "</body></html>";
		eventPanel.battleText.setText(battleText);
		eventPanel.refresh();
		leftPanel.refresh(trainer);
		rightPanel.refresh(aiTrainer);


	}
	
	private boolean checkEnd() {
		boolean endBattle = false;
		if(trainer.teamFainted() || aiTrainer.teamFainted())
			endBattle = true;
		return endBattle;
	}
	
private JPanel endPanel() {
		
		JPanel borderContainer = new JPanel (new BorderLayout());
		borderContainer.setOpaque(false);
		JPanel endPanel = new JPanel( new GridBagLayout());
		endPanel.setOpaque(false);
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel dialogue1 = new JLabel("Battle is over!");
        dialogue1.setFont(new Font("BigNoodleTitling", Font.PLAIN, 20));
        dialogue1.setForeground(Color.white);
        dialogue1.setHorizontalAlignment(SwingConstants.CENTER);
	    gbc.gridx = 0;  
	    gbc.gridy = 0;
		endPanel.add(dialogue1, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        String winner;
        if(trainer.teamFainted())
        	winner = "Opponent Wins!";
        else
        	winner = "You Win!";
        JLabel dialogue2 = new JLabel(winner);
        dialogue2.setFont(new Font("BigNoodleTitling", Font.PLAIN, 20));
        dialogue2.setForeground(Color.white);
        dialogue2.setHorizontalAlignment(SwingConstants.CENTER);
	    gbc.gridx = 0;  
	    gbc.gridy = 1;
		endPanel.add(dialogue2, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.gridx = 0;  
	    gbc.gridy = 2;
		JButton goBack = new JButton("Return to Menu");
		goBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	trainer.getTeam().clear();
				SelectionPanel selectionPanel = null;
				try {
					selectionPanel = new SelectionPanel(cardLayout, container);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				UI.clip.stop();
				UI.playSound("../music/selection_menu.wav");
				container.add(selectionPanel, "1");
				cardLayout.show(container, "1");
            }
        });
		goBack.setFont(new Font("BigNoodleTitling", Font.PLAIN, 18));
		goBack.setBackground(new Color(242, 170, 107));
		goBack.setForeground(Color.white);
		endPanel.add(goBack, gbc);
        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(800, 30));
        northPanel.setOpaque(false);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(800, 30));
        bottomPanel.setOpaque(false);


		borderContainer.add(endPanel, BorderLayout.CENTER);
		borderContainer.add(bottomPanel, BorderLayout.SOUTH);
		borderContainer.add(northPanel, BorderLayout.NORTH);
		
		return borderContainer;
	}
	
}
