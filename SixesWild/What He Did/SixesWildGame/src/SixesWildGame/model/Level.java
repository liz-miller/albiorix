 package SixesWildGame.model;

import java.io.Serializable;
import java.util.Random;

import SixesWildGame.boundary.SixesWildGUI;


/**
 * Creates a generic level for Sixes' Wild West.
 *  
 * 
 * @author Liz Miller & npmahowald
 */

//STATUS: needs body method implementations. Last modified: 4/26

public abstract class Level implements Serializable{
	private String levelType;
	private int score;
	private int lvlNum;
	private int[] starThreshold;
	private int[] tileWeight;
	private int[] multWeight;
	private int eliminateTilesLeft = 3;
	private int swapTilesLeft = 3;
	private boolean eliminateTileState;
	private boolean swapTileState;
	private Board board;
	static Random randomGenerator = new Random();

	/**
	 * Constructor for Level which creates a new generic level by taking in the appropriate values
	 * @param starThreshold The threshold values for one, two or three stars
	 * @param tileWeight The percentages for the chance of tiles having a certain value listed as a series of numbers
	 * @param multWeight The percentages for the chance of tiles having a certain multiplier listed as a series of numbers
	 * @param lvlNum The number of the level being worked on
	 */
	protected Level(int[] starThreshold, int[] tileWeight, int[] multWeight, int lvlNum){ 
	this.starThreshold = starThreshold;
	this.tileWeight = tileWeight;
	this.multWeight = multWeight;
	this.eliminateTilesLeft = eliminateTilesLeft;
	this.swapTilesLeft = swapTilesLeft;
	this.score = 0;
	eliminateTileState = false;
	swapTileState = false;
	board = new Board(this);
	this.lvlNum = lvlNum;
}
	
	/**
	 * Saves a given level to disk.
	 * @param l The level to save
	 */
	public void saveLevel(Level l){
		
	}
	
	/**
	 * Opens a given level from disk.
	 * @param l The level to load
	 */
	public void loadLeve(Level l){
		
	}
	
	/**
	 * restart() is an abstract class defined by each individual level type
	 */
	public abstract Level restart();
	
	/**
	 * generateTile() generates the level's tiles based on the given tile weights
	 */
	public Tile generateTile(){
		int val, mult;
		int rand = randomGenerator.nextInt(100);
		if(rand < tileWeight[0]){
			val = 1;
		}else if(rand < tileWeight[0] + tileWeight[1]){
			val = 2;
		}else if(rand < tileWeight[0] + tileWeight[1] + tileWeight[2]){
			val = 3;
		}else if(rand < tileWeight[0] + tileWeight[1] + tileWeight[2] + tileWeight[3]){
			val = 4;
		}else if(rand <  tileWeight[0] + tileWeight[1] + tileWeight[2] + tileWeight[3] + tileWeight[4]){
			val = 5;
		}else{
			val = 6;
		}
		if(rand < multWeight[0]){
			mult = 1;
		}else if(rand < multWeight[0] + multWeight[1]){
			mult = 2;
		}else{
			mult = 3;
		}
		return new Tile(val, mult, null);
		
		
		
		
	
	}
	
	/**
	 * getType(Level l) is a getter which returns the type of the level.
	 * @param l the level to get 
	 * @return l.levelType
	 */
	public String getType(Level l){
		return l.levelType;
	}
	/**
	 * decreaseMovesLeft() is an abstract class defined by each individual level type
	 */
	public abstract void decreaseMovesLeft();
	/**
	 * getMovesLeft() is an abstract class defined by each individual level type
	 */
	public abstract int getMovesLeft();
	/**
	 * endGame() is an abstract class defined by each individual level type
	 */
	public abstract boolean endGame();
	/**
	 * decreaseEliminateTilesLeft() removes one of the eliminated tile 
	 * special moves
	 */
	public void decreaseEliminateTilesLeft(){
		eliminateTilesLeft--;
	}
	/**
	 * getEliminateTilesLeft() is a getter which returns the remaining number 
	 * of eliminated tile special moves
	 * @return eliminateTilesLeft
	 */
	public int getEliminateTilesLeft(){
		return eliminateTilesLeft;
	}
	/**
	 * decreaseSwapTilesLeft() removes one of the swap tile 
	 * special moves
	 */
	public void decreaseSwapTilesLeft(){
		swapTilesLeft--;
		
	}
	/**
	 * getSwapTilesLeft() is a getter which which returns the remaining number 
	 * of swap tile special moves
	 * @return swapTilesLeft
	 */ 
	public int getSwapTilesLeft(){
		return swapTilesLeft;
	}
	/**
	 * getBoard() is a getter which returns the board in the level
	 * @return board
	 */
	public Board getBoard(){
		return board;
	}
	/**
	 * incrementScore(int i) increase the level's score by a certain value
	 * @param i The value to increase the score by
	 */
	public void incrementScore(int i){
		score = score + i;
	}
	/**
	 * getScore() is a getter which returns the score
	 * @return score
	 */
	public int getScore(){
		return score;
	}
	/**
	 * getLevelNum() is a getter which returns the level number
	 * @return lvlNum
	 */
	public int getLevelNum(){
		return lvlNum;
	}
	
	/**
	 * getEliminateTileState() is a getter which returns the 
	 * status of the eliminate tile special move state
	 * @return eliminateTileState
	 */
	public boolean getEliminateTileState(){
		return eliminateTileState;
	}
	/**
	 * setEliminateTileState(boolean b) is a setter which changes the 
	 * status of the eliminate tile special move state
	 * @param b The desired status of the eliminate tile special move state
	 */
	public void setEliminateTileState(boolean b){
		eliminateTileState = b;
	}
	/**
	 * getSwapTileState() is a getter which returns the 
	 * status of the status tile special move state
	 * @return swapTileState
	 */
	public boolean getSwapTileState(){
		return swapTileState;
	}
	/**
	 * setSwapTileState(boolean b) is a setter which changes the 
	 * status of the swap tile special move state
	 * @param b The desired status of the swap tile special move state
	 */
	public void setSwapTileState(boolean b){
		swapTileState = b;
	}
	/**
	 * numStars() is a getter which returns the level's current 
	 * number of stars
	 * @return int 
	 */
	public int numStars(){
		if(score > starThreshold[2]) return 3;
		if(score > starThreshold[1]) return 2;
		if(score > starThreshold[0]) return 1;
		
		return 0;

	}
	
	
	
	
	
	
}


