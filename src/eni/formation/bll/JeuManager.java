package eni.formation.bll;


import java.awt.Dimension;

import javax.swing.Timer;

import eni.formation.bo.Balle;
import eni.formation.bo.Joueur;
import eni.formation.bo.LevelGenerator;


public interface JeuManager {
	public void setJoueur(Joueur j);
	public void setBalle(Balle balle);
	public Joueur getJoueur();
	public Balle getBalle();
	public void turnRight();
	public void turnLeft();
	public Dimension getDimension();
	public void setDimension(Dimension dimension);
	public void setIsStart(boolean isStart);
	public boolean getIsStart();

	public boolean getLeftIsPressed();
	public boolean getRightIsPressed();
	public void setLeftIsPressed(boolean b);
	public void setRightIsPressed(boolean b);
	
	public Timer getTimerDeplacement() ;
	public void setTimerDeplacement(Timer timerDeplacement) ;
	public Timer getTimerAffichage() ;
	public void setTimerAffichage(Timer timerAffichage);
	public void moveBall();
	
	public void setLevelGenerator(LevelGenerator levelGenerator);
	public LevelGenerator getlevelGenerator();
	public String getScore();
	public boolean isOver() ;
}
