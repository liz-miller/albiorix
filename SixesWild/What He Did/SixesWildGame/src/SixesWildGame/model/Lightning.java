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
	
	public Lightning(int time, int[] starThreshold, int eliminateTilesLeft, int swapTilesLeft){
		super(starThreshold);
		this.levelType = "Lightning";
		this.time = time;
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
	
	@Override
	public void decreaseMovesLeft(){
	}
	
	@Override
	public int getMovesLeft(){
		return 0;
	}
	
	public int getTime(){
		return time;
	}
	public void setTime(int t){
		time = t;
	}
	
	public boolean endGame(){
		return time == 0;
	}
}
