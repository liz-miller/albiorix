package SixesWildGame.model;

import SixesWildGame.model.Level;
import SixesWildGame.model.Square;
import SixesWildGame.model.Tile;


/**
 * Creates an Elimination Level.
 * 
 * @author Liz Miller & npmahowald
 *
 */
public class Elimination extends Level {
	private String levelType;
	private int[] starThreshold;
	private int movesLeft = 30;
	private int eliminateTilesLeft = 3;
	private int swapTilesLeft = 3;
	
	public Elimination(int movesLeft, int[] starThreshold, int eliminateTilesLeft, int swapTilesLeft){
		super(starThreshold);
		this.levelType = "Elimination";
		this.movesLeft = movesLeft;
		super.getBoard().markAll();
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
