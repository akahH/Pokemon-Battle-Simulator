package projecto_final_2021_B;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SelectionPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PlayerTrainer trainer;
	private static AITrainer aiTrainer;


	
	public SelectionPanel(CardLayout layout, JPanel container) throws IOException{
		
		trainer = new PlayerTrainer();
		aiTrainer = new AITrainer();
		setLayout(new BorderLayout());
		PokemonPool pokemonPool = new PokemonPool();
		List<Pokemon> pokemonList = pokemonPool.pokemonPool();
		PokemonPoolPanel poolpanel = new PokemonPoolPanel(trainer, pokemonList);
		poolpanel.buildPanel();
		
		
		JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(100, 500));
		JPanel rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(100, 500));
		
		//painel com o logo
		File file = new File("../images/logo.png");
		BufferedImage image = ImageIO.read(file);
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridBagLayout());
        ImagePanel logo = new ImagePanel(image);
        logo.setPreferredSize(new Dimension(200,90));
        northPanel.add(logo);
        northPanel.setPreferredSize(new Dimension(800, 100));
        
        //painel com regras e botão
        JPanel bottomPanel = new JPanel( new GridBagLayout());
        bottomPanel.setPreferredSize(new Dimension(800, 100));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel rule1 = new JLabel("Please choose 3 Pokémon to begin the battle");
        rule1.setFont(new Font("BigNoodleTitling", Font.PLAIN, 20));
        rule1.setHorizontalAlignment(SwingConstants.CENTER);
	    gbc.gridx = 0;  
	    gbc.gridy = 0;
	    bottomPanel.add(rule1, gbc);
        JLabel rule2 = new JLabel("The first Pokémon you choose will be the first active Pokémon");
        rule2.setFont(new Font("BigNoodleTitling", Font.PLAIN, 20));
	    gbc.gridx = 0;  
	    gbc.gridy = 1;
	    bottomPanel.add(rule2,gbc);
        JButton next = new JButton("Start Battle!");
	    gbc.gridx = 0;  
	    gbc.gridy = 2;
        bottomPanel.add(next, gbc);
        next.setBackground(new Color(242, 170, 107));
        next.setForeground(Color.white);
        next.setFont(new Font("BigNoodleTitling", Font.PLAIN, 18));
		next.addActionListener( new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {

				
				PokemonPool pokemonPool = new PokemonPool();
				List<Pokemon> cloneList = pokemonPool.pokemonPool();
				
				if(trainer.getTeam().size()==3) {
					
					while( aiTrainer.getTeam().size() < 3) {
						int pokemonNumerAI = (int) (Math.random() * (9));
						if(!aiTrainer.getTeam().contains(cloneList.get(pokemonNumerAI)))
							aiTrainer.addPokemonToTeam(cloneList.get(pokemonNumerAI));
					}
					trainer.chooseActivePokemon(0);
					aiTrainer.chooseActivePokemon();
					BattlePanel battlePanel = null;
					try {
						battlePanel = new BattlePanel(trainer, aiTrainer, layout, container);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					container.add(battlePanel, "2");
					layout.show(container, "2");
					UI.clip.stop();
					UI.playSound("../music/battle_1.wav");
				}

				
			}
		});
        
		add(poolpanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);
		add(northPanel, BorderLayout.NORTH);
		setOpaque(false);
		setVisible(true);
	}
	


}
