package SixesWildGame.model;

import java.util.Random;

//NOTE: This class has not been updated since we switched to the new structure -AB 4/27


// The model class for the board
public class Board {
	Square[][] allSquares;
	public final static int boardHW = 9;
	static Random randomGenerator = new Random();
	
	public Board () {
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

	// TODO: I'm confused as to the purpose of this method - does it create new Tiles to be added to the Square located at r,c? if so, it shouldn't
	// need to return anything, just alter the Square. I'm setting this to void for now. may be changed later. -AB 4/27
	public void SpawnTile(int r, int c) {
		Square currentSquare = getSquare(r,c);
		currentSquare.addTile(new Tile(randomGenerator.nextInt(6) + 1, 1, currentSquare));
		
		//return new Tile(randomGenerator.nextInt(6) + 1, r, c, 1);	 //old -AB 4/27
	} 
	
	public Tile generateRandomTile(){
		return new Tile(randomGenerator.nextInt(6) + 1, 1, null);
	}

	public Tile getTile(int r, int c) {
		return allSquares[r][c].getTile();
	}
	
	public Square getSquare(int r, int c){
		return allSquares[r][c];
	}
}

