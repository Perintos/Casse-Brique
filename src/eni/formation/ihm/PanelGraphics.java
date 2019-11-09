package eni.formation.ihm;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import eni.formation.bll.JeuManager;
import eni.formation.bll.JeuManagerFact;
import eni.formation.bo.Balle;
import eni.formation.bo.Joueur;
import eni.formation.bo.LevelGenerator;

@SuppressWarnings("serial")
public class PanelGraphics extends JPanel implements KeyListener, ActionListener {
	private JeuManager jeu;

	public PanelGraphics(){		
		this.setFocusable(true);
		this.addKeyListener(this);
		this.setFocusTraversalKeysEnabled(false);
		
		this.jeu = JeuManagerFact.getInstance();
		this.jeu.setJoueur(new Joueur());
		this.jeu.setBalle(new Balle());
		this.jeu.setLevelGenerator(new LevelGenerator());
		this.jeu.setTimerDeplacement(new Timer(20, this));
		this.jeu.getTimerDeplacement().start();
		this.jeu.setTimerAffichage(new Timer(5, this));
		this.jeu.getTimerAffichage().start();
	}
	
	public void paint(Graphics g){
		this.jeu.setDimension(new Dimension(this.getWidth(), this.getHeight()));
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0 , this.getWidth(), this.getHeight());
		
		this.jeu.getlevelGenerator().drawLevel((Graphics2D)g);

		g.setColor(Color.WHITE);
		g.fillRect(jeu.getJoueur().getPosX(), this.jeu.getJoueur().getPosY(), Joueur.getWidth(), Joueur.getHeight());
		
		g.setColor(Color.YELLOW);
		g.fillOval(this.jeu.getBalle().getPosX(), this.jeu.getBalle().getPosY(), Balle.getWidth() , Balle.getHeight());
		
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, this.getWidth(), 5);
		g.fillRect(0, 0, 5, this.getHeight());
		g.fillRect(this.getWidth()-5, 0, 5, this.getHeight());
		
		g.setColor(Color.YELLOW);
		g.drawString(this.jeu.getScore() , 30, 30);
		
		if(this.jeu.isOver()){
			g.setColor(Color.YELLOW);
			g.drawString("GAME OVER / " + this.jeu.getScore() , this.jeu.getDimension().width/2-90, this.jeu.getDimension().height/4 *3 );
		}
		
		g.dispose();
	}

	
	public void keyPressed(KeyEvent arg0) {
		if(KeyEvent.VK_RIGHT == arg0.getKeyCode()){	
			this.jeu.setRightIsPressed(true);
		}	
		
		else if(KeyEvent.VK_LEFT == arg0.getKeyCode()){		
			this.jeu.setLeftIsPressed(true);
		}
		
		else if(KeyEvent.VK_SPACE == arg0.getKeyCode()) {
			this.jeu.setIsStart(true);
		}
	}

	public void keyReleased(KeyEvent arg0) {
		if(KeyEvent.VK_RIGHT == arg0.getKeyCode()){	
			this.jeu.setRightIsPressed(false);
		}	
		
		else if(KeyEvent.VK_LEFT == arg0.getKeyCode()){		
			this.jeu.setLeftIsPressed(false);
		}
	}

	public void keyTyped(KeyEvent arg0) {}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.jeu.getTimerDeplacement())
		{
			if(this.jeu.getIsStart())	
				this.jeu.moveBall();

			if(this.jeu.getLeftIsPressed())
				this.jeu.turnLeft();
			
			if(this.jeu.getRightIsPressed())
				this.jeu.turnRight();
		}
		else if(e.getSource() == this.jeu.getTimerAffichage())
		{
			this.repaint();
		}
	}
}
