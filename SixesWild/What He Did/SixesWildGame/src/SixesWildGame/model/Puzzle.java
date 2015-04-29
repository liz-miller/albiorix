package SixesWildGame.model;

import java.sql.Time;

/**
 * Creates a Puzzle Level.
 * 
 * @author Liz Miller & npmahowald
 *
 */
public class Puzzle extends Level{
	private String levelType;
	private boolean timer;
	private int[] starThreshold;
	private int movesLeft = 30;
	private int eliminateTilesLeft = 3;
	private int swapTilesLeft = 3;
	private Board board;
	
	public Puzzle(int movesLeft, int[] starThreshold, int eliminateTilesLeft, int swapTilesLeft){
		super();
		this.levelType = "Puzzle";
		this.movesLeft = movesLeft;
		this.timer = false;
	}

	@Override
	public Level restart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateTiles() {
		// TODO Auto-generated method stub
		
	}
	public void decreaseMovesLeft(){
		movesLeft--;
		
	}
	public int getMovesLeft(){
		return movesLeft;
	}
	
}
