package eni.formation.bo;

import java.awt.Rectangle;

public class Joueur {
	private static final int width = 90;
	private static final int height = 10;
	private static final int initialPosX = 310;
	private static final int initialPosY = 550;

	private int posX = 0;
	private int posY = 0;
	
	public Joueur() {
		this.posX = initialPosX;
		this.posY = initialPosY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosy(int posY) {
		this.posY = posY;
	}

	public static int getWidth() {
		return width;
	}

	public static int getHeight() {
		return height;
	}

	public static int getInitialposX() {
		return initialPosX;
	}

	public static int getInitialposY() {
		return initialPosY;
	}
	
	public Rectangle getRect() {
		return new Rectangle(this.posX, this.getPosY(), Joueur.width, Joueur.height);
	}
}	