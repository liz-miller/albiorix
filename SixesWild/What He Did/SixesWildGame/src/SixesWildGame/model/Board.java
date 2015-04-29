package SixesWildGame.model;

import java.util.Random;
import java.util.Stack;

import javax.swing.JButton;

/**
 * Board - this Class 
 * @author Alex & npmahowald
 *
 */
public class Board {
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
		
		//This creates a grid of Squares with no Tiles 
		for (int r = 0; r < boardHW; r++) {
			for (int c = 0; c < boardHW; c++) {
				allSquares[r][c] = new Square(r,c);
				allSquares[r][c].addTile(generateRandomTile());
				
				
			}
		}
		
	}

	/**
	 * TODO: I'm confused as to the purpose of this method - does it create new Tiles to be added to the Square located at r,c? 
	 * if so, it shouldn't need to return anything, just alter the Square. I'm setting this to void for now. may be changed later. -AB 4/27
	 * @param r - row the the Board
	 * @param c - column of the Board
	 */
	
	/**
	 * Create a randomly generated Tile
	 * @return Tile - a new Tile with a random value, 1 as a multiplier, and null as its parent
	 */
	public Tile generateRandomTile(){
		return new Tile(randomGenerator.nextInt(6) + 1, randomGenerator.nextInt(3) + 1, null);
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
	
	public void pushToSelected(Tile tile){
		if(tile != null && (swipedTiles.isEmpty() || -1 == swipedTiles.lastIndexOf(tile))){
		tile.setSelected(true);
		swipedTiles.push(tile);
		}
	}
	
	public Tile popFromSelected(){
		Tile tile = swipedTiles.pop();
		tile.setSelected(false);
		return tile;
	}
	
	public Tile peekAtSelected(){
		return swipedTiles.peek();
	}
	
	public void remAllFromSelected(){
		Tile tile;
		while(!swipedTiles.empty()){
		tile = swipedTiles.pop();
		tile.setSelected(false);
		}
	}
	
	public int numSwiped(){
		return swipedTiles.size();
	}
	
	public int countSwiped(){
		int count = 0;
		for(int i = 0; i < numSwiped(); i++){
			count = count + swipedTiles.elementAt(i).getValue();
		}
		return count;
	}
	public int eliminateSwipedTiles(){
		
		int multipliers = 1;
		
		Tile tile, downTile;
		Square upSquare;
		
		while(!swipedTiles.empty()){
			
			tile = swipedTiles.pop();
			multipliers = multipliers*tile.getMult();
			
			if(tile.getParent().getCol() == 0){
				
				tile.getParent().addTile(generateRandomTile());
			}else{
				upSquare = allSquares[tile.getParent().getRow()][tile.getParent().getCol() - 1];
				downTile = upSquare.getTile();
				tile.getParent().addTile(downTile);
				swipedTiles.push(new Tile(1, 1, upSquare));
			
			}
			
			
			
		}
		return multipliers;
	}

	public void resetBoard(){
		for (int r = 0; r < boardHW; r++) {
			for (int c = 0; c < boardHW; c++) {
				allSquares[r][c] = new Square(r,c);
				allSquares[r][c].addTile(generateRandomTile());
				
				
			}
		}
	}
	public void swapTiles(){
		Tile firstTile = swipedTiles.pop();
		Tile secondTile = swipedTiles.pop();
		Square toSquare = secondTile.getParent();
		firstTile.setSelected(false);
		secondTile.setSelected(false);
		firstTile.getParent().addTile(secondTile);
		toSquare.addTile(firstTile);
	}
	public Level getParent(){
		return parent;
	}
}

