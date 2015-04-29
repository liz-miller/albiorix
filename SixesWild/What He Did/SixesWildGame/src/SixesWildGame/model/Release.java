package SixesWildGame.model;


/**
 * Creates a Release Level.
 * 
 * @author Liz Miller & npmahowald
 *
 */
public class Release extends Level{
	private String levelType;
	private int[] starThreshold;
	private int movesLeft = 30;
	private int eliminateTilesLeft = 3;
	private int swapTilesLeft = 3;
	private Board board;
	
	public Release(int movesLeft, int[] starThreshold, int eliminateTilesLeft, int swapTilesLeft){
		super(starThreshold);
		this.levelType = "Release";
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

}
