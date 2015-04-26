 package SixesWildGame.model;


/**
 * Creates a generic level for Sixes' Wild West.
 *  
 * 
 * @author Liz Miller
 */

//STATUS: needs body method implementations. Last modified: 4/26

public abstract class Level {
	private String gameName;
	private Square squares[];
	private Tile tiles[];
	private int numMoves;
	private int numStars;
	protected int difficulty;
	
	protected Level(){ 
	this.gameName = gameName;
	this.squares = squares;
	this.tiles = tiles;
	this.numMoves = numMoves;
	this.numStars = numStars;
	this.difficulty = difficulty;
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
	public int[] calculateTilePercent(int ones, int twos, int threes, int fours, int fives, int sixes){
		int percents[] = new int[6];
		int sum = ones + twos + threes + fours + fives + sixes;
		percents[1] = ones/sum;
		percents[2] = twos/sum;
		percents[3] = threes/sum;
		percents[4] = fours/sum;
		percents[5] = fives/sum;
		percents[6] = sixes/sum;
		
		return percents;
	
	}
	
	/**
	 * Generates tiles. Override for specific level functionality.
	 * @param levelType
	 */
	public abstract void generateTiles();
	
	/**
	 * Returns the name of a level.
	 * @param Level l
	 * @return
	 */
	public String getName(Level l){
		return l.gameName;
	}
	
	/**
	 * Returns the number of moves of a level.
	 * @param Level l
	 * @return
	 */
	public int getNumMoves(Level l){
		return l.numMoves;
	}
	
	/**
	 * Returns the number of stars of a level.
	 * @param Level l
	 * @return
	 */
	public int getNumStars(Level l){
		return l.numStars;
	}
	
	/**
	 * Returns the difficulty of a level.
	 * @param Level l
	 * @return
	 */
	public int getDifficulty(Level l){
		return l.difficulty;
	}
	
	
	
}


