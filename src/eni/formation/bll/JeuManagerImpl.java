package eni.formation.bll;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.Timer;

import eni.formation.bo.Balle;
import eni.formation.bo.Joueur;
import eni.formation.bo.LevelGenerator;

public class JeuManagerImpl implements JeuManager{
	private static final int PAS_DEPLACEMENT = 5; 
	
	private Joueur joueur;
	private Balle balle;
	private Dimension dimension;
	private boolean isStart = false;
	private Timer timerDeplacement;
	private Timer timerAffichage;
	private boolean leftIsPressed = false;
	private boolean rightIsPressed = false;
	private boolean isOver = false;

	private LevelGenerator levelGenerator;
	
	private int score = 0;

	
	public void turnRight() {
		if(this.joueur.getPosX() <= this.dimension.getWidth()-Joueur.getWidth())
		{
			this.joueur.setPosX(this.joueur.getPosX()+PAS_DEPLACEMENT);
				if(!isStart)
					this.balle.setPosX(this.balle.getPosX()+PAS_DEPLACEMENT);
		}
	}

	public void turnLeft() {
		if(this.joueur.getPosX() > 0)
		{
			this.joueur.setPosX(this.joueur.getPosX()-PAS_DEPLACEMENT);		
				if(!isStart)
					this.balle.setPosX(this.balle.getPosX()-PAS_DEPLACEMENT);
		}
	}

	public void setJoueur(Joueur j) {
		this.joueur = j;		
	}

	public Joueur getJoueur() {
		return this.joueur;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public void setBalle(Balle balle) {
		this.balle = balle;
	}

	public Balle getBalle() {
		return this.balle;
	}

	public static int getPasDeplacement() {
		return PAS_DEPLACEMENT;
	}

	public void setIsStart(boolean isStart) {
		this.isStart = isStart;
	}

	public boolean getIsStart() {
		return this.isStart;
	}

	public boolean getLeftIsPressed(){
		return this.leftIsPressed;
	}

	public boolean getRightIsPressed(){
		return this.rightIsPressed;
	}

	public void setLeftIsPressed(boolean b){
		this.leftIsPressed = b;
	}

	public void setRightIsPressed(boolean b){
		this.rightIsPressed = b;
	}

	public Timer getTimerDeplacement() {
		return timerDeplacement;
	}

	public void setTimerDeplacement(Timer timerDeplacement) {
		this.timerDeplacement = timerDeplacement;
	}

	public Timer getTimerAffichage() {
		return timerAffichage;
	}

	public void setTimerAffichage(Timer timerAffichage) {
		this.timerAffichage = timerAffichage;
	}
	
	public void setLevelGenerator(LevelGenerator levelGenerator) {
		this.levelGenerator = levelGenerator;		
	}

	@Override
	public void moveBall() {
		Rectangle rectBrick = null;
		Rectangle rectBall = null;
		
		if(this.balle.getRect().intersects(this.joueur.getRect()))
			this.getBalle().setDirectionY(-this.balle.getDirectionY());
		
		A : for(int i = 0 ; i < this.levelGenerator.getRow() ; i++)
		{
			for(int j = 0 ; j < this.levelGenerator.getCol() ; j++) {
				if(this.levelGenerator.isExist(i, j)) {
					rectBrick = this.levelGenerator.getBrick(i, j);
					rectBall = this.balle.getRect();
					
					if(rectBrick.intersects(rectBall)){
						this.score += LevelGenerator.getPointbrick();
						this.levelGenerator.deleteBrick(i, j);
						
						if(rectBall.getX() + rectBall.width - this.balle.getDirectionX() <= rectBrick.getX() +1 || rectBall.getX() - this.balle.getDirectionX() -1 >= rectBrick.getX() + rectBrick.width)
							this.balle.setDirectionX(-this.balle.getDirectionX());
						else
							this.balle.setDirectionY(-this.balle.getDirectionY());
						
						break A;
					}
				}
			}
		}
		
		this.balle.setPosX(this.balle.getPosX() + this.balle.getDirectionX());
		this.balle.setPosY(this.balle.getPosY() + this.balle.getDirectionY());
		
		if(this.balle.getPosX()<0)
			this.balle.setDirectionX(-this.balle.getDirectionX());
		if(this.balle.getPosY()<0)
			this.balle.setDirectionY(-this.balle.getDirectionY());
		if(this.balle.getPosX() >= (this.dimension.width - Balle.getWidth()))
			this.balle.setDirectionX(-this.balle.getDirectionX());
		if(this.balle.getPosY() > this.dimension.height || this.levelGenerator.getNbrBrick() == 0){
			this.isOver = true;
			this.timerDeplacement.stop();
		}
	}

	public LevelGenerator getlevelGenerator() {
		return this.levelGenerator;
	}
	
	public String getScore() {
		return "Score : " + this.score;
	}

	public boolean isOver() {
		return this.isOver;
	}
}
