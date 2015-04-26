package SixesWildGame.model;

import java.awt.Color;


/**
 * Tile - this Object will be the building blocks for a Move and will be contained within a Square
 * @author Alex
 *
 */
public class Tile {
	
	private int value;
	private Color color;
	private Square parent;
	private int multiplier;
	
	/**
	 * Constructor for Tile - This specifies the value, multiplier, and parent Square of the tile. Using this information the color
	 * of the Tile will be determined
	 * @param val - the visible value of the Tile
	 * @param mult - the multiplier of the Tile, which can be 1, 2, or 3, and will only be visible if this value is not 1
	 * @param parent - the Square in which the Tile is currently located
	 */
	public Tile(int val, int mult, Square parent){
		this.value = val;
		setParent(parent);
		setMult(mult);
		updateColor();
	}
	
	/**
	 * getter for the Tile value
	 * @return tile.value
	 */
	public int getValue(){
		return value;
	}
	
	/**
	 * setter to change the multiplier of the Tile
	 * @param mult - the new multiplier
	 */
	public void setMult(int mult){
		this.multiplier = mult;
	}
	
	/**
	 * getter to return the multiplier of the Tile
	 * @return tile.multiplier
	 */
	public int getMult(){
		return multiplier;
	}
	
	/**
	 * method to determine and set the Color of the Tile using the value. Each value has a pre-determined Color
	 */
	private void updateColor(){
		//TODO: make sure these colors match up
		if(value == 1){
			//set color to (white)
			this.color = Color.WHITE;
		}
		else if(value == 2){
			//set color to (red)
			this.color = Color.RED;
		}
		else if(value == 3){
			//set color to (orange)
			this.color = Color.ORANGE;
		}
		else if(value == 4){
			//set  color to (yellow)
			this.color = Color.YELLOW;
		}
		else if(value == 5){
			//set color to ( blue)
			this.color = Color.BLUE;
		}
		else if(value == 6){
			//set color to (pink)
			this.color = Color.PINK;
		}
	}
	
	/**
	 * getter which returns the parent Square 
	 * @return tile.parent
	 */
	public Square getParent(){
		return this.parent;
	}
	
	/**
	 * setter which sets the Tile's parent Square
	 * @param parent - new parent Square
	 */
	public void setParent(Square parent){
		this.parent = parent;
	}
}
