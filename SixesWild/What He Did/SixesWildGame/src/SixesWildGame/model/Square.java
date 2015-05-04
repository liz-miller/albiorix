package SixesWildGame.model;

import java.awt.Color;
import java.io.Serializable;

/**
 * Square - this Object will be the building blocks to a Board, and can contain a Tile which can be used to a Move
 * If a Square is inert, then it cannot be selected and it cannot contain a Tile.
 * @author Alex
 *
 */

public class Square implements Serializable{
	
	private int row;
	private int col;
	private Tile tile;
	private boolean isMarked;
	private boolean isSixesGoal; //put this here to be used later possibly for release levels
	private boolean isInert;
	
	/**
	 * Most basic constructor of Square - only the position of the Square is determined
	 * @param r - Row location of the Square
	 * @param c - Column location of the Square
	 */
	public Square(int r, int c){
		this.row = r;
		this.col = c;
		this.tile = null;
		isMarked = false;
		this.isInert = false;
		this.isSixesGoal = false;
	}
	
	/**
	 * Constructor of an inert or a goal Square.  This is a Square whose a Tile cannot be added and it cannot be marked,
	 * or a square which is a goal in release.
	 * @param r - Row location of the Square
	 * @param c - Column location of the Square
	 * @param i - the value which determines the isInert and isSixesGoal values. A value of 1 sets only isInert to true.
	 * a value of 2 will set isInert to true and isSixesGoal to true if the Square's column is 8. Any other value will set
	 * both isInert and isSixesGoal to false
	 */
	public Square(int r, int c, int i){
		this.row = r;
		this.col = c;
		this.tile = null;
		this.isMarked = false;
		
		//set the isInert and isSixesGoal values depending on i
		if (i == 1){
			this.isInert = true;
			this.isSixesGoal = false;
		} else if(i == 2){
			
			if(r != 8) {
				System.err.println("Square: Invalid Specification of column, release goals should be in row 9");
				this.isSixesGoal = false;
			}
			else {
				this.isSixesGoal = true;
			}
			this.isInert = true;

		} else{
			System.out.println("Square: Invalid Specification in Inert/Goal square constructor, must be 1, or 2. Square"
					+ "is neither inert nor a six goal.");
			this.isInert = false;
			this.isSixesGoal = false;
			
		}
	}
	
	/**
	 * Constructor of Square with row and column locations determined and a Tile that has already been created
	 * @param r - Row location of the Square
	 * @param c - Column location of the Square
	 * @param tile - current Tile which is located in this Square
	 */
	public Square(int r, int c, Tile tile){
		this.row = r;
		this.col = c;
		this.tile = tile;
		this.tile.setParent(this);
		this.isMarked = false;
		this.isInert = false;
	}
	
	/**
	 * Constructor of a basic Square where the Tile contained in it has not yet been created
	 * @param r - Row location of the Square
	 * @param c - Column location of the Square
	 * @param val - value of the Tile located in the Square
	 * @param multiplier - multiplier of the Tile located in the Square
	 */
	public Square(int r, int c, int val, int multiplier){
		this.row = r;
		this.col = c;
		this.tile = new Tile(val, multiplier, this);
		this.isMarked = false;
		this.isInert = false;
	}
	
	/**
	 * Constructor of Square meant for the Elimination levels with row and column locations determined, a Tile that 
	 * has already been created, and the possibility to set whether or not the Square is already marked
	 * @param r - Row location of the Square
	 * @param c - Column location of the Square
	 * @param tile - current Tile which is located in the this Square
	 * @param isMarked - whether or not the Square is already marked
	 */
	public Square(int r, int c, Tile tile, boolean isMarked){
		this.row = r;
		this.col = c;
		this.tile = tile;
		this.tile.setParent(this);
		this.isMarked = isMarked;
		this.isInert = false;
	}
	
	
	/**
	 * Constructor of Square meant for the Elimination levels with row and column locations determined, a Tile that 
	 * has not yet been created, and the possibility to set whether or not the Square is already marked
	 * @param r - Row location of the Square
	 * @param c - Column location of the Square
	 * @param val - value of the Tile located in the Square
	 * @param multiplier - multiplier of the Tile located in the Square
	 * @param isMarked - whether or not the Square is already marked
	 */
	public Square(int r, int c, int val, int multiplier, boolean isMarked){
		this.row = r;
		this.col = c;
		this.tile = new Tile(val, multiplier, this);
		this.isMarked = isMarked;
		this.isInert = false;
	}
	
	
	/**
	 * Changes the status of the isMarked property to true as long as the Square is not inert
	 */
	public void setMarked(){
		if(isInert){
			//System.err.println("Square: Attempted to mark an inert Square");
			return;
		}
		isMarked = true;
	}
	
	/**
	 * Changes the status of the isMarked property to false as long as the Square is not inert
	 */
	public void setUnMarked(){
		if(isInert){
			System.err.println("Square: Attempted to unmark an inert Square");
			return;
		}
		isMarked = false;
	}
	
	/**
	 * returns the value of the isMarked property
	 * @return tile.isMarked
	 */
	public boolean isMarked(){
		return isMarked;
	}
	
	/**
	 * Getter to return the value of isInert
	 * @return this.isInert
	 */
	public boolean isInert() {
		return isInert;
	}
	
	
	/**
	 * This method allows a Square to become inert. This will only be used for Board set-up reasons
	 * @param inertVal
	 */
	
	//NOTE: for some reason this prohibits the game from running --- fix it somehow. 
	/*
	public void setInert(boolean inertVal){
		if(inertVal){
			isInert = true;
			this.getTile(); //remove the current tile
			isMarked = false;
		}
		else{
			isInert = false;
			isMarked = false;		
		}
	}
	*/

	
	/**
	 * Getter to return the value of isSixesGoal
	 * @return this.isSixesGoal
	 */
	public boolean isSixesGoal() {
		return isSixesGoal;
	}
	
	/**
	 * returns the row location of the Square
	 * @return row
	 */
	public int getRow(){
		return row;
	}
	
	/**
	 * returns the column location of the Square
	 * @return col
	 */
	public int getCol(){
		return col;
	}

	/**
	 * Adds a tile to the Square and sets the Tile's parent to this
	 * Note: if the Square is inert, then this action will not change the status of the Square
	 * @param tile - Tile to be added to the Square
	 */
	public void addTile(Tile tile){
		if(isInert && (isSixesGoal && tile.getValue() != 6)){
			return;
		}
		this.tile = tile;
		this.tile.setParent(this);
	}
	
	/**
	 * Removes the Tile from the Square, and changes the Tile's parent to null. This is much like Pile.get() from A1.
	 * Note: if the Square does not currently have a Tile, it just returns null and does not change the Square.
	 * Note #2: if the Square is inert, then it should not have a Tile, but return null anyways 
	 * @return this.tile
	 */
	public Tile getTile(){
		if(isInert && !isSixesGoal){
			System.err.println("Square: Attempted to get a Tile from an inert Square");
			return null;
		}
		if(this.tile == null){
			return null;
		}
		else {
			Tile thisTile = tile;
			tile.setParent(null);
			this.tile = null;
			return thisTile;
		}
	}
	
	/**
	 * Does not change the Square-Tile relationship, but returns a new Tile which has the same data as the tile located in the Square. 
	 * This is much like Pile.peek() from A1
	 * @return this.tile
	 */
	public Tile peekTile(){
		if(isInert && !isSixesGoal){
			System.err.println("Square: Attempted to access a Tile from an inert Square");
			return null;
		}
		return this.tile;
	}
	
	/**
	 * equals() - an override of whether or not the current Square and the given Square are the same.
	 * This method simply checks whether or not they have the same row and column location, as well as Tile, isMarked,
	 * and isInert
	 * be changed at a later time depending on usage
	 * @param other
	 * @return whether or not the two Squares have the same location, Tile, and isMarked value
	 */
	public boolean equals(Square other){
		
		boolean tilesEqual;
		
		if(other == null){
			return false;
		}
		//The two Squares' Tiles must be equal. This is necessary for null Tile cases
		if(this.peekTile() == null && other.peekTile() == null){
			tilesEqual = true;
		}
		else if(this.peekTile() == null || other.peekTile() == null){
			tilesEqual = false;			
		}
		else {
			tilesEqual = this.peekTile().equals(other.peekTile());
		}
		
		return this.getCol() == other.getCol() &&
				this.getRow() == other.getRow() &&
				tilesEqual &&
				this.isMarked() == other.isMarked() &&
				this.isInert == other.isInert();
	}

	/**
	 * return the color of the Tile located in the current Square. If there is no Tile, return Black
	 * If the Square is inert, also return Black, but throw an error
	 * @return color of the Tile 
	 */
	public Color getTileColor(){
		
		if(isInert && !isSixesGoal){
			System.err.println("Square: attempted to get color of an inert square");
			return Color.BLACK;
		}
		else if(this.peekTile() == null){
			return Color.BLACK;
		}
		else{
			return this.peekTile().getColor();
		}
	}

	/**
	 * get the value of the Tile located in the current Square. If there is no Tile, return 0. Also, if the Square is inert, return 0
	 * @return value of the Tile
	 */
	public int getTileValue() {
		if(isInert && !isSixesGoal){
			System.err.println("Square: Square is inert but you tried to access its Tile's Value");
			return 0;
		}
		
		if(this.peekTile() == null){
			System.err.println("Square: No Tile associated with this Square but you attempted to get its value");
			return 0;
		}
		else {
			return this.peekTile().getValue();
		}
	}
	
	/** 
	 * get the multiplication value of the Tile. If there is no Tile, return 0.  -AB 4/28
	 * @return sqaure.peekTile().getMult()
	 */
	public int getTileMult() {
		if(this.peekTile() == null){
			System.err.println("Square: no Tile associated with this Square but you attempted to get its multiplier");
			return 0;
		}
		else {
			return this.peekTile().getMult();
		}
	}
	
} //end Square
