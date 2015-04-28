package SixesWildGame.model;

import java.awt.Color;

/**
 * Square - this Object will be the building blocks to a Level, and can contain a Tile which can be used to a Move
 * @author Alex
 *
 */

public class Square{
	
	int row;
	int col;
	Tile tile;
	boolean isMarked;
	
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
	}
	
	
	/**
	 * Changes the status of the isMarked property to true
	 */
	public void setMarked(){
		isMarked = true;
	}
	
	/**
	 * Changes the status of the isMarked property to false
	 */
	public void setUnMarked(){
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
	 * returns the row location of the Square
	 * @return tile.row
	 */
	public int getRow(){
		return row;
	}
	
	/**
	 * returns the column location of the Square
	 * @return tile.col
	 */
	public int getCol(){
		return col;
	}

	/**
	 * Adds a tile to the Square and sets the Tile's parent to this
	 * @param tile - Tile to be added to the Square
	 */
	public void addTile(Tile tile){
		this.tile = tile;
		this.tile.setParent(this);
	}
	
	/**
	 * Removes the Tile from the Square, and changes the Tile's parent to null. This is much like Pile.get() from A1.
	 * Note: if the Square does not currently have a Tile, it just returns null and does not change the Square.
	 * @return this.tile
	 */
	public Tile getTile(){
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
	 * Does not change the Square-Tile relationship, but returns the tile located in the Square. This is much like 
	 * Pile.peek() from A1
	 * @return this.tile
	 */
	public Tile peekTile(){
		return this.tile;
	}
	
	/**
	 * equals() - an override of whether or not the current Square and the given Square are the same.
	 * This method simply checks whether or not they have the same row and column location, as well as Tile and 
	 * isMarked
	 * be changed at a later time depending on usage
	 * @param other
	 * @return whether or not the two Squares have the same location, Tile, and isMarked value
	 */
	public boolean equals(Square other){
		return this.getCol() == other.getCol() &&
				this.getRow() == other.getRow() &&
				this.peekTile().equals(other.peekTile()) &&
				this.isMarked() == other.isMarked();

	}

	/**
	 * return the color of the Tile located in the current Square. If there is no Tile, return Black -AB 4/27
	 * @return color of the Tile 
	 */
	public Color getTileColor(){
		if(this.peekTile() == null){
			return Color.BLACK;
		}
		else{
			return this.peekTile().getColor();
		}
	}

	/**
	 * get the value of the Tile located in the current Square. If there is no Tile, return 0. - AB 4/27
	 * @return value of the Tile
	 */
	public int getTileValue() {
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
	 * @return
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
}
