package SixesWildGame.model;


/**
 * Creates a Release Level.
 * 
 * @author Liz Miller & npmahowald
 *
 */
public class Release extends Level{
	private String levelType;
	private int movesLeft;
	
	/**
	 * Constructor for Release which creates a new Puzzle level by taking in the appropriate values
	 * @param movesLeft The number of moves remaining listed as the initial amount of moves in the constructor
	 * @param starThreshold The threshold values for one, two or three stars
	 * @param tileWeight The percentages for the chance of tiles having a certain value listed as a series of numbers
	 * @param multWeight The percentages for the chance of tiles having a certain multiplier listed as a series of numbers
	 * @param eliminateTilesLeft The number of eliminate tiles special moves remaining
	 * @param swapTilesLeft The number of swap tiles special moves remaining
	 * @param lvlNum The number of the level being worked on
	 */
	public Release(int movesLeft, int[] starThreshold, int[] tileWeight, int[] multWeight, int eliminateTilesLeft, int swapTilesLeft, int lvlNum){
		super(starThreshold, tileWeight, multWeight, lvlNum, eliminateTilesLeft, swapTilesLeft);
		this.levelType = "Release";
		this.movesLeft = movesLeft;
		
		//TEMPORARY METHOD
		//super.getBoard().makeBoardReleaseable();
	}

	public void decreaseMovesLeft(){
		movesLeft--;
		
	}
	
	
	/**
	 * getMovesLeft() is a getter for the number of moves left
	 */
	public int getMovesLeft(){
		return movesLeft;
	}
	
	/**
	 * endGame() designates to end the release level type when all of the goal 
	 * squares have been filled with sixes
	 */
	public boolean endGame(){
		boolean hasAGoal = false;
		boolean endGame = true;
		Square almostGoal, square;
		for (int r = 0; r < Board.boardHW; r++) {
				square = super.getBoard().getSquare(8, r);
				if(square.isSixesGoal()){
					hasAGoal = true;
					almostGoal = super.getBoard().getSquare(square.getRow()-1, square.getCol());
					
					if(almostGoal.peekTile().getValue() == 6 
							&& square.peekTile() == null){
						System.err.println("Cool");
						
						super.getBoard().pushToSelected(almostGoal.peekTile());
						super.getBoard().eliminateSwipedTiles();
						square.addTile(new Tile(6, 1, square));
						
					}else if(square.peekTile() == null){
						endGame = false;
					}
					
				}

			
		}
		if(!hasAGoal){
			System.err.println("Release: Board is stored in release level but has no goal squares");
			return false;
		}
		return (endGame || movesLeft == 0);
	}
	
	public String getType(){
		return "Release";
	}

}
