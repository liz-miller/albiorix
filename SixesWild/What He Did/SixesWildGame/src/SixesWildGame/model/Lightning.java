package SixesWildGame.model;

import java.sql.Time;

/**
 * Creates a Lightning Level.
 * 
 * @author Liz Miller & npmahowald
 *
 */
public class Lightning extends Level{
	private String levelType;
	private int score;
	private int[] starThreshold;
	private int eliminateTilesLeft = 3;
	private int swapTilesLeft = 3;
	private boolean eliminateTileState;
	private boolean swapTileState;
	private Board board;
	private int time;
	
	/**
	 * Constructor for Lightning which creates a new Lightning level by taking in the appropriate values
	 * @param time The amount of time remaining listed as the initial amount of time in the constructor
	 * @param starThreshold The threshold values for one, two or three stars
	 * @param tileWeight The percentages for the chance of tiles having a certain value listed as a series of numbers
	 * @param multWeight The percentages for the chance of tiles having a certain multiplier listed as a series of numbers
	 * @param eliminateTilesLeft The number of eliminate tiles special moves remaining
	 * @param swapTilesLeft The number of swap tiles special moves remaining
	 * @param lvlNum The number of the level being worked on
	 */
	public Lightning(int time, int[] starThreshold, int[] tileWeight, int[] multWeight, int eliminateTilesLeft, int swapTilesLeft, int lvlNum){
		super(starThreshold, tileWeight, multWeight, lvlNum);
		this.levelType = "Lightning";
		this.time = time;
		board = new Board(this);
	}

	/**
	 * decreaseMovesLeft() overrides the method to do nothing 
	 * as the lightning game type doesn't use  moves
	 */
	@Override
	public void decreaseMovesLeft(){
	}
	
	/**
	 * getMovesLeft() overrides the number of moves left in a lightning level to 0
	 */
	@Override
	public int getMovesLeft(){
		return 0;
	}
	
	/**
	 * getTime() is a getter for the time
	 * @return time
	 */
	public int getTime(){
		return time;
	}
	/**
	 * setTime() is a setter for the time
	 * @param t The time to be set
	 */
	public void setTime(int t){
		time = t;
	}
	/**
	 * endGame() designates to end the lightning level type when the timer runs out
	 */
	public boolean endGame(){
		return time == 0;
	}
	
	public String getType(){
		return "Lightning";
	}
}
