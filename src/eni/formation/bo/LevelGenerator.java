package eni.formation.bo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class LevelGenerator {
	private static final int POINT_BRICK = 5;
	private boolean level[][];
	private int row = 8;
	private int col = 3;
	private int brickHeight = 40;
	private int brickWidth = 70;
	private int nbrBrick = 0;
	
	public LevelGenerator() {
		this.level = new boolean[row][col];
		for(int i =0 ; i < this.row ; i++) {
			for(int j = 0 ; j < this.col ; j++) {
				this.level[i][j] = true;
				nbrBrick ++;
			}
		}
	}
	
	public void drawLevel(Graphics2D g) {
		for(int i =0 ; i < this.row ; i++) {
			for(int j = 0 ; j < this.col ; j++) {
				if(this.level[i][j] == true)
				{
					g.setColor(Color.WHITE);
					g.fillRect(i*brickWidth+60, j*brickHeight+60, this.brickWidth, this.brickHeight);
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.BLACK);
					g.drawRect(i*brickWidth+60, j*brickHeight+60, this.brickWidth, this.brickHeight);
				}
			}
		}
	}

	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public boolean isExist(int i, int j) {
		return this.level[i][j];
	}
	
	public void deleteBrick(int i, int j){
		this.level[i][j] = false;
		this.nbrBrick--;
	}
	
	public Rectangle getBrick(int i, int j) {		
		return new Rectangle(i*brickWidth+60, j*brickHeight+60, this.brickWidth, this.brickHeight);
	}
	
	public static int getPointbrick() {
		return POINT_BRICK;
	}

	public int getNbrBrick() {
		return nbrBrick;
	}	
}
