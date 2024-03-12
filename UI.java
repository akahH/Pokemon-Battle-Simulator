package projecto_final_2021_B;

import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class UI {
	
	static Clip clip;
	
	public static void main(String[] args) throws IOException {
		CardLayout cardLayout = new CardLayout();
		File file = new File("../images/backgroundImage.png");
		BufferedImage image = ImageIO.read(file);
		JPanel container = new ImagePanel(image);
		SelectionPanel selectionPanel = new SelectionPanel(cardLayout, container);
		
		
		JFrame main = new JFrame("Main Frame");

		
		container.setLayout(cardLayout);
		container.add(selectionPanel, "1");
		cardLayout.show(container, "1");
		main.setSize(1024,576);
		main.add(container);
		main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		main.setLocationRelativeTo(null);
		main.setVisible(true);
		playSound("../music/selection_menu.wav");
		
		
		
	}
	
	public static synchronized void playSound(final String url) {
		  new Thread(new Runnable() {
		  // The wrapper thread is unnecessary, unless it blocks on the
		  // Clip finishing; see comments.
		    public void run() {
		      try {
		    	clip  = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(url).getAbsoluteFile());
		        clip.open(inputStream);
		        clip.start();
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start();
		}
	

	
}
