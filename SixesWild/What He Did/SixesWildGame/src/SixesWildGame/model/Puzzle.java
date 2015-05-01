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
//	Application app;
	
	
	public Puzzle(int movesLeft, int[] starThreshold, int eliminateTilesLeft, int swapTilesLeft){
		super(starThreshold);
		this.levelType = "Puzzle";
		this.movesLeft = movesLeft;
		board = new Board(this);
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
	
	public boolean endGame(){
		return movesLeft == 0;
	}


}
