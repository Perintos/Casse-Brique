package eni.formation.ihm;

import java.awt.Color;
import javax.swing.JFrame;

public class Demo {
	public static void main(String[] args) {
		JFrame fenetre = new JFrame();

	    fenetre.setTitle("Cassebrique");
	    fenetre.setSize(700, 600);
	    fenetre.setBackground(Color.WHITE);
	    fenetre.setLocationRelativeTo(null);
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    fenetre.setResizable(false);
	    
		PanelGraphics pan = new PanelGraphics();
	    fenetre.add(pan);
	    
	    fenetre.setVisible(true);
	}
}
