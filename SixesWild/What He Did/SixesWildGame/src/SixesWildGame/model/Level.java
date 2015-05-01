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
	private int[] starThreshold;
	private int[] tileWeight;
	private int[] multWeight;
	private int eliminateTilesLeft = 3;
	private int swapTilesLeft = 3;
	private boolean eliminateTileState;
	private boolean swapTileState;
	private Board board;
	static Random randomGenerator = new Random();

	
	protected Level(int[] starThreshold, int[] tileWeight, int[] multWeight){ 
	this.starThreshold = starThreshold;
	this.tileWeight = tileWeight;
	this.multWeight = multWeight;
	this.eliminateTilesLeft = eliminateTilesLeft;
	this.swapTilesLeft = swapTilesLeft;
	this.score = 0;
	eliminateTileState = false;
	swapTileState = false;
	board = new Board(this);
}
	
	/**
	 * Saves a given level to disk.
	 * @param l
	 */
	public void saveLevel(Level l){
		
	}
	
	/**
	 * Opens a given level from disk.
	 * @param l
	 */
	public void loadLeve(Level l){
		
	}
	
	/**
	 * Restarts current level.
	 * @return Level
	 */
	public abstract Level restart();
	
	/**
	 * Calculates the percentage occurance of each numbered tile.
	 * @param ones
	 * @param twos
	 * @param threes
	 * @param fours
	 * @param fives
	 * @param sixes
	 * @return int[] percentage
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
	 * Returns the name of a level.
	 * @param Level l
	 * @return
	 */
	public String getType(Level l){
		return l.levelType;
	}
	
	public abstract void decreaseMovesLeft();
	
	public abstract int getMovesLeft();
	
	public abstract boolean endGame();
	
	public void decreaseEliminateTilesLeft(){
		eliminateTilesLeft--;
		
	}
	public int getEliminateTilesLeft(){
		return eliminateTilesLeft;
	}
	public void decreaseSwapTilesLeft(){
		swapTilesLeft--;
		
	}
	public int getSwapTilesLeft(){
		return swapTilesLeft;
	}

	public Board getBoard(){
		return board;
	}
	public void incrementScore(int i){
		score = score + i;
	}
	public int getScore(){
		return score;
	}
	public boolean getEliminateTileState(){
		return eliminateTileState;
	}
	
	public void setEliminateTileState(boolean b){
		eliminateTileState = b;
	}
	
	public boolean getSwapTileState(){
		return swapTileState;
	}
	
	public void setSwapTileState(boolean b){
		swapTileState = b;
	}
	
	public int numStars(){
		if(score > starThreshold[2]) return 3;
		if(score > starThreshold[1]) return 2;
		if(score > starThreshold[0]) return 1;
		
		return 0;

	}
	
	
	
	
	
	
}


