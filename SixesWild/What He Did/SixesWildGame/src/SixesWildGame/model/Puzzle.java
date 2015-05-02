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
	
	
	public Puzzle(int movesLeft, int[] starThreshold, int[] tileWeight, int[] multWeight, int eliminateTilesLeft, int swapTilesLeft, int lvlNum){
		super(starThreshold,  tileWeight,  multWeight, lvlNum);
		this.levelType = "Puzzle";
		this.movesLeft = movesLeft;
		board = new Board(this);
	}

	@Override
	public Level restart() {
		// TODO Auto-generated method stub
		return null;
	}


	public void decreaseMovesLeft(){
		movesLeft--;
		
	}
	public int getMovesLeft(){
		return movesLeft;
	}
	
	public boolean endGame(){
		return movesLeft == 0;
	}


}
