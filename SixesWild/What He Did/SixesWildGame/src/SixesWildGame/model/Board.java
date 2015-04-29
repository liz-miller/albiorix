package SixesWildGame.model;

import java.util.Random;
import java.util.Stack;

/**
 * Board - this Class 
 * @author Alex && npmahowald
 *
 */
public class Board {
	private Square[][] allSquares;
	private Stack<Square> swipedSquares;
	public final static int boardHW = 9;
	static Random randomGenerator = new Random();
	
	public Board () {
		swipedSquares = new Stack<Square>(); // Used to hold the tiles as they were
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
	
	public void pushToSelected(Square square){
		if(square != null && square.peekTile() != null && (swipedSquares.isEmpty() || square != swipedSquares.peek())){
		square.peekTile().setSelected(true);
		swipedSquares.push(square);
		}
	}
	
	public Square popFromSelected(){
		Square square = swipedSquares.pop();
		square.peekTile().setSelected(false);
		return square;
	}
	
	public Square peekAtSelected(){
		return swipedSquares.peek();
	}
	
	public void remAllFromSelected(){
		Square square;
		while(!swipedSquares.empty()){
		square = swipedSquares.pop();
		square.peekTile().setSelected(false);
		}
	}
	
	public int numSwiped(){
		return swipedSquares.size();
	}
	
	public int countSwiped(){
		int count = 0;
		for(int i = 0; i < numSwiped(); i++){
			count = count + swipedSquares.elementAt(i).getTileValue();
		}
		return count;
	}
	public void eliminateSwipedTiles(){
		
		
		while(!swipedSquares.empty()){
			
			Square square = swipedSquares.pop();
			square.peekTile().setSelected(false);
			if(square.getCol() == 0){
				square.addTile(generateRandomTile());
			}else{
				Square downSquare = allSquares[square.getRow()][square.getCol() - 1];
				square.addTile(downSquare.peekTile());
				swipedSquares.push(downSquare);
			
			}
			
			
		}
	}
}

