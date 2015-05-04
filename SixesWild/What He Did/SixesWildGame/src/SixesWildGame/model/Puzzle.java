package SixesWildGame.model;

import java.sql.Time;
import SixesWildGame.boundary.VictoryScreen;
import SixesWildGame.boundary.Application;
/**
 * Creates a Puzzle Level.
 * 
 * @author Liz Miller & npmahowald
 *
 */
public class Puzzle extends Level{
	private String levelType;
	private int[] starThreshold;
	private int movesLeft;
	private int eliminateTilesLeft = 3;
	private int swapTilesLeft = 3;
	private Board board;
	
	/**
	 * Constructor for Puzzle which creates a new Puzzle level by taking in the appropriate values
	 * @param movesLeft  The number of moves remaining listed as the initial amount of moves in the constructor
	 * @param starThreshold The threshold values for one, two or three stars
	 * @param tileWeight The percentages for the chance of tiles having a certain value listed as a series of numbers
	 * @param multWeight The percentages for the chance of tiles having a certain multiplier listed as a series of numbers
	 * @param eliminateTilesLeft The number of eliminate tiles special moves remaining
	 * @param swapTilesLeft The number of swap tiles special moves remaining
	 * @param lvlNum The number of the level being worked on
	 */
	public Puzzle(int movesLeft, int[] starThreshold, int[] tileWeight, int[] multWeight, int eliminateTilesLeft, int swapTilesLeft, int lvlNum){
		super(starThreshold,  tileWeight,  multWeight, lvlNum);
		this.levelType = "Puzzle";
		this.movesLeft = movesLeft;
		board = new Board(this);
	}

	/**
	 * restart() restarts the level
	 */
	@Override
	public Level restart() {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     *  decreaseMovesLeft() decreases the number of moves that are left
     */
	public void decreaseMovesLeft(){
		movesLeft--;
		
	}
	/**
	 * getMovesLeft() is a getter for the number of moves left
	 */
	public int getMovesLeft(){
		return movesLeft;
	}
	/**
	 * endGame() designates to end the puzzel level type when the player runs out of moves
	 */
	public boolean endGame(){
		return movesLeft == 0;
	}


}
