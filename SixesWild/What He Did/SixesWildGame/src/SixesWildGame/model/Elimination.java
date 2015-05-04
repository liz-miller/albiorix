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
	private int movesLeft;
	private int eliminateTilesLeft = 3;
	private int swapTilesLeft = 3;
	/**
	 * Constructor for Elimination which creates a new elimination level by taking in the appropriate values
	 * @param starThreshold The threshold values for one, two or three stars
	 * @param tileWeight The percentages for the chance of tiles having a certain value listed as a series of numbers
	 * @param multWeight The percentages for the chance of tiles having a certain multiplier listed as a series of numbers
	 * @param eliminateTilesLeft The number of eliminate tiles special moves remaining
	 * @param swapTilesLeft The number of swap tiles special moves remaining
	 * @param lvlNum The number of the level being worked on
	 */
	public Elimination(int[] starThreshold, int[] tileWeight, int[] multWeight, int eliminateTilesLeft, int swapTilesLeft, int lvlNum){
		super(starThreshold, tileWeight, multWeight, lvlNum);
		this.levelType = "Elimination";
		this.movesLeft = 0;
		super.getBoard().markAll();
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
     * decreaseMovesLeft() decreases the number of moves that are left
     */
	public void decreaseMovesLeft(){
		movesLeft++;
		
	}
	/**
	 * getMovesLeft() is a getter for the number of moves left
	 */
	public int getMovesLeft(){
		return movesLeft;
	}
	/**
	 * endGame() designates to end the elimination level type when all of the squares are
	 * unmarked 
	 */
	public boolean endGame(){
		for (int r = 0; r < super.getBoard().boardHW; r++) {
			for (int c = 0; c < super.getBoard().boardHW; c++) {
				if(super.getBoard().getSquare(r, c).isMarked()) return false;
				
			}
		}
		return true;
	}
}
