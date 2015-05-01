package SixesWildGame.model;

import java.awt.Color;
import java.io.Serializable;


/**
 * Tile - this Object will be the building blocks for a Move and will be contained within a Square
 * @author Alex
 *
 */
public class Tile implements Serializable{
	
	private int value;
	private Square parent;
	private int multiplier;
	private boolean selected;
	
	/**
	 * Constructor for Tile - This specifies the value, multiplier, and parent Square of the tile. Using this information the color
	 * of the Tile will be determined
	 * @param val - the visible value of the Tile
	 * @param mult - the multiplier of the Tile, which can be 1, 2, or 3, and will only be visible if this value is not 1
	 * @param parent - the Square in which the Tile is currently located
	 */
	public Tile(int val, int mult, Square parent){
		//make sure val is within bounds before setting tile.value
		if(!isValidValue(val)){
			System.out.println("Tile: value is out of bounds. Setting value to 1");
			this.value = 1;
		}
		else{
			this.value = val;
		}
		
		//then update the other class values
		setParent(parent);
		setMult(mult);
		getColor();
		setSelected(false);
		
	}
	
	/**
	 * isValidValue - makes sure a value is in the correct bounds (1-6)
	 * @param val - value to be checked
	 */
	private boolean isValidValue(int val){
		return (val > 0 && val < 7);
	}
	
	/**
	 * isValidMult - makes sure a given multiplier is within bounds (1-3)
	 * @param mult - multiplier value to be checked
	 */
	private boolean isValidMult(int mult){
		return (mult > 0 && mult < 4);
	}
	
	/**
	 * getter for the Tile value
	 * @return tile.value
	 */
	public int getValue(){
		return value;
	}
	
	/** 
	 * setter for the Tile value
	 * @param val - new value for the Tile
	 */
	public void setVal(int val){
		if(!isValidValue(val)){
			System.out.println("Tile: Value is out of bounds");
		}
		else{
			this.value = val;
			getColor();
		}
	}
	
	/**
	 * setter to change the multiplier of the Tile. If the Tile's value is 6, then its multiplier cannot be changed from 1.
	 * @param mult - the new multiplier
	 */
	public void setMult(int mult){
		if(!isValidMult(mult)){
			System.out.println("Tile: new multiplier is out of bounds");
		}
		else{
			if(this.value == 6){
				this.multiplier = 1;
			}
			else {
				this.multiplier = mult;
			}
		}

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
	public Color getColor(){
		Color color;
		if(selected){
			color = Color.GRAY;
		} else {
			if(value == 1){
				//set color to (white)
				color = Color.RED;
			}
			else if(value == 2){
				//set color to (red)
				color = Color.ORANGE;
			}
			else if(value == 3){
				//set color to (orange)
				color = Color.CYAN;
			}
			else if(value == 4){
				//set  color to (yellow)
				color = Color.MAGENTA;
			}
			else if(value == 5){
				//set color to ( blue)
				color = Color.GREEN;
			}
			else if(value == 6){
				//set color to (pink)
				color = Color.BLUE;
			} else{
				color = Color.BLACK;
			}
		}
		return color;
	}
	
	/**
	 * getter for the Tile color value
	 * @return tile.color
	 */
	/*public Color getColor(){
		if(this.color == null){
			updateColor();
		}
		return this.color;
	}*/
	
	/**
	 * getter which returns the parent Square 
	 * @return tile.parent
	 */
	public Square getParent(){
		return this.parent;
	}
	
	/**
	 * setter which sets the Tile's parent Square and changes the Parent's tile to the current tile
	 * if it is not already set
	 * @param parent - new parent Square
	 */
	public void setParent(Square parent){
		//set this Tile's parent to parent
		this.parent = parent;
		
		//set the parent's Tile to this as long as parent is not null AND sets the parent
		//Square's Tile to this if it is not already set
		if(parent!= null && this.parent.peekTile() != this){
			this.parent.addTile(this);
		}
	}
	
	/**
	 * equals(Tile t) - compares the value and multiplier, and returns true if they are both the same
	 * @param Tile t - Tile to be compared with current Tile
	 * @return whether or not the two Tiles can be considered equal
	 */
	public boolean equals(Tile t){
		return (this.getValue() == t.getValue() &&
				this.getMult() == t.getMult());
		
	}
	
	public void setSelected(boolean selState){
		selected = selState;
	}
	public boolean getSelected(){
		return selected;
	}
	
} //end Tile 
