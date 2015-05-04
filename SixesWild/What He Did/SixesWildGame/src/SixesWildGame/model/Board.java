package SixesWildGame.model;

import java.io.Serializable;
import java.util.Random;
import java.util.Stack;


/**
 * Board - this Class 
 * @author Alex & npmahowald
 */
public class Board implements Serializable{
	private Square[][] allSquares;
	private Stack<Tile> swipedTiles;
	public final static int boardHW = 9;
	static Random randomGenerator = new Random();
	private Level parent;
	
	public Board (Level parent) {
		this.parent = parent;
		swipedTiles = new Stack<Tile>(); // Used to hold the tiles as they were
												// swiped
		// So far all this does is generate a random board, and he wrote it
		allSquares  = new Square[boardHW][boardHW];
		
		//This creates a grid of Squares, and add Tiles as long as parent is not null
		for (int r = 0; r < boardHW; r++) {
			for (int c = 0; c < boardHW; c++) {
				allSquares[r][c] = new Square(r,c);
				if(parent !=null){
					allSquares[r][c].addTile(parent.generateTile());	
				}	
			}
		}	
		
		
	}
	
	/**
	 * setSquare(Square) places a Square in the Board in the location of its row and column values
	 * @param square - Square to be placed
	 */
	public void setSquare(Square square){
		allSquares[square.getCol()][square.getRow()] = square;
	}
	

	/**
	 * getTile() - Using the Board's row and column, return the Tile from that location
	 * @param r - row of the Board
	 * @param c - column of the Board
	 * @return Tile located at the Board's row and column
	 */
	public Tile getTile(int r, int c) {
		return allSquares[c][r].peekTile();
	}
	
	/**
	 * Using the Board's row and column, return the Square from that location
	 * @param r - row of the Board
	 * @param c - column of the Board
	 * @return Square located at the Board's row and column
	 */
	public Square getSquare(int r, int c){
		return allSquares[c][r];
	}
	
	/**
	 * pushToSelected(Tile) - add a Tile to the top of the  swipedTiles stack. Tile will not be added if 
	 * the Tile is already on the stack
	 * @param tile - Tile to be added to the swipedTiles stack
	 */
	public void pushToSelected(Tile tile){
		if(tile != null && (swipedTiles.isEmpty() || -1 == swipedTiles.lastIndexOf(tile))){
			tile.setSelected(true);
			swipedTiles.push(tile);
		}
	}
	
	/**
	 * popFromSelected() - takes off the Tile on the top of the swipedTiles Stack. 
	 * @return Tile - top Tile on the stack
	 */
	public Tile popFromSelected(){
		Tile tile = swipedTiles.pop();
		tile.setSelected(false);
		return tile;
	}
	
	/**
	 * peekAtSelected() - returns the Tile on the top of the swipedTiles Stack without removing it
	 * @return Tile - top Tile on the stack
	 */
	public Tile peekAtSelected(){
		return swipedTiles.peek();
	}
	
	/**
	 * remAllFromSelected() - empty the swipedTiles Stack by removing all the Tiles
	 */
	public void remAllFromSelected(){
		Tile tile;
		while(!swipedTiles.empty()){
		tile = swipedTiles.pop();
		tile.setSelected(false);
		}
	}
	
	/**
	 * numSwiped() - returns the number of Tiles which have been swiped in the current move
	 * @return size of the swipedTiles Stack
	 */
	public int numSwiped(){
		return swipedTiles.size();
	}
	
	/**
	 * countSwiped() - calculates the sum of all the Tiles that have been selected
	 * @return int - sum of all selected Tiles
	 */
	public int countSwiped(){
		int count = 0;
		for(int i = 0; i < numSwiped(); i++){
			count = count + swipedTiles.elementAt(i).getValue();
		}
		return count;
	}
	
	/**
	 * unMarkSwipedSquares - set all Tiles on the swipedTiles Stack to be unmarked
	 */
	public void unMarkSwipedSquares(){
		for(int i = 0; i < swipedTiles.size(); i++){
			swipedTiles.elementAt(i).getParent().setUnMarked();
		}
	}
	
	/**
	 * eliminateSwipedTiles() - remove all swipedTiles from the Board and the swipedTiles Stack, and
	 * repopulate the Board as necessary. Return the running multiplier of the swipedTiles Stack.
	 * @return int - the value of all the swiped Tiles' multiplier multiplied together
	 */
	public int eliminateSwipedTiles(){
		
		int multipliers = 1;
		
		Tile tile;
		Square upSquare;
		
		//as long as the swipedTiles Stack is not empty
		while(!swipedTiles.empty()){
			
			//remove the Tile from the Stack and update multipliers
			tile = swipedTiles.pop();
			multipliers = multipliers*tile.getMult();
			upSquare = getAboveSquare(tile.getParent());
			
			//add a random Tile to the current Square - none to shift downwards
			if(upSquare == null){
				tile.getParent().addTile(parent.generateTile());
			
			//Make sure the gravity works 
			//TODO: I will double check, but I'm pretty sure you don't need this first line
				}else{
				tile.getParent().addTile(upSquare.getTile());
				swipedTiles.push(new Tile(1, 1, upSquare));
			}	
			
		}
		return multipliers;
	}

	/**
	 * resetBoard() - generate a new Tile for all Squares on the board as long as they are not a
	 * sixesGoal. Note: if the current Level is a Release level and the Square's Tile is a 6, a new 
	 * Tile will not be generated for that Square
	 */
	public void resetBoard(){
		for (int r = 0; r < boardHW; r++) {
			for (int c = 0; c < boardHW; c++) {
				
				if(!allSquares[r][c].isSixesGoal() && !allSquares[r][c].isInert() 
						&& !(parent instanceof Release && allSquares[r][c].getTileValue() == 6)){
					allSquares[r][c].addTile(parent.generateTile());
				}
				
				
			}
		}
	}
	
	/**
	 * swapTiles() - swap the two Square locations of the 2 most recently selected Tiles
	 */
	public void swapTiles(){
		Tile firstTile = swipedTiles.pop();
		Tile secondTile = swipedTiles.pop();
		Square toSquare = secondTile.getParent();
		firstTile.setSelected(false);
		secondTile.setSelected(false);
		firstTile.getParent().addTile(secondTile);
		toSquare.addTile(firstTile);
	}
	
	/**
	 * Return the Level type of this current Board
	 * @return Level type
	 */
	public Level getParent(){
		return parent;
	}
	
	/**
	 * markAll() - Iterate through the Board and set all Squares as Marked
	 */
	public void markAll(){
		for (int r = 0; r < boardHW; r++) {
			for (int c = 0; c < boardHW; c++) {
				allSquares[r][c].setMarked();
				
			}
		}
	}
	

	/**
	 * getAboveSquare(Square) - returns the first non-inert Square located directly above the given Square
	 * @param belowSquare
	 * @return
	 */
	public Square getAboveSquare(Square belowSquare){
		if(belowSquare == null){
			return null;
		}
		int col = belowSquare.getCol();
		boolean inert = belowSquare.isInert();
		
		//If not at the top Square, make sure the Square above is not inert. if it is not, return that Square
		while(col > 0){
			inert = allSquares[belowSquare.getRow()][--col].isInert();
			if(!inert) return allSquares[belowSquare.getRow()][col];
		}
		//If there are no non-inert Squares above the current Square, return null
		return null;
	}
	
}
	

