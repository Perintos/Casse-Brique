package eni.formation.bo;

import java.awt.Rectangle;

public class Balle {
	private static final int width = 20;
	private static final int height = 20;
	
	private static final int initialPosX = 345 ;
	private static final int initialPosY = 530;
	
	private int posX;
	private int poxY;
	private int directionX=-5;
	private int directionY=-5;
	
	public Balle() {
		this.posX = initialPosX;
		this.poxY = initialPosY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return poxY;
	}

	public void setPosY(int poxY) {
		this.poxY = poxY;
	}

	public static int getWidth() {
		return width;
	}

	public static int getHeight() {
		return height;
	}

	public int getDirectionX() {
		return directionX;
	}

	public void setDirectionX(int directionX) {
		this.directionX = directionX;
	}

	public int getDirectionY() {
		return directionY;
	}

	public void setDirectionY(int directionY) {
		this.directionY = directionY;
	}
	
	public Rectangle getRect() {
		return new Rectangle(this.posX, this.getPosY(), Balle.width, Balle.height);
	}
	
	 
}
