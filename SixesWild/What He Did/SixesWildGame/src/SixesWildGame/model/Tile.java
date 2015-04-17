package SixesWildGame.model;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;



public class Tile {

	private int value;
	private int row;
	int col;
	private int mult;
	private JLabel mySecondaryLabel;
	
	public Tile (int val, int row, int col, int mul){
		this.value = val;
		this.row = row;
		this.col = col;
		this.mult = mul;
		
	}
	public int getValue(){
		return value;
	}
	public int getMult(){
		return mult;
	}
	public JLabel setMultLabel(int xcoord, int ycoord, int tileSize){
		
		mySecondaryLabel.setBounds(xcoord + tileSize* (3 / 4), ycoord + tileSize* (3 / 4), tileSize / 4, tileSize / 4);
		return mySecondaryLabel;
	}
}
