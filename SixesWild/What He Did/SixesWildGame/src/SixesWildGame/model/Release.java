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
	
	public Release(int movesLeft, int[] starThreshold, int eliminateTilesLeft, int swapTilesLeft){
		super(starThreshold);
		this.levelType = "Release";
		this.movesLeft = movesLeft;
		
		//TEMPORARY METHOD
		super.getBoard().makeBoardReleaseable();
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
		boolean hasAGoal = false;
		boolean endGame = true;
		Square almostGoal, square;
		for (int r = 0; r < Board.boardHW; r++) {
				square = super.getBoard().getSquare(8, r);
				if(square.isSixesGoal()){
					hasAGoal = true;
					almostGoal = super.getBoard().getAboveSquare(square);
					if(almostGoal.getTileValue() == 6 && square.peekTile() == null){

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

}
