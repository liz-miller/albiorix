import SixesWildGame.model.*;
import junit.framework.TestCase;


public class TestPuzzle extends TestCase{
	
	Puzzle thisPuzzle;
	
	public void setUp(){
		
		int[] starThresh = {500, 1000, 1500};
		int[] tileWeight = {10, 10, 10, 10, 10, 10};
		int[] multWeight = {35, 35, 30};
		
		thisPuzzle = new Puzzle(10, starThresh, tileWeight, multWeight, 2, 2, 1);
		
	}
	
	public void tearDown(){
		
		setUp();
		
	}
	
	//Test the Puzzle-only methods
	public void testBasicPuzzle(){
		
		assertEquals("Puzzle", thisPuzzle.getType());
		
		assertEquals(10, thisPuzzle.getMovesLeft());
		
		while(!thisPuzzle.endGame()){
			thisPuzzle.decreaseMovesLeft();
		}
		
		assertEquals(0, thisPuzzle.getMovesLeft());
		
	}
	
	//Test inherited special moves
	//I believe this is not passing because of the way that these variables are used in the Level class. 
	//I will talk about this at our 5p meeting today, before making any serious changes. -AB 5/4
	public void testPuzzleSpecialMoves(){
		
		assertEquals(2, thisPuzzle.getEliminateTilesLeft());
		assertEquals(2, thisPuzzle.getSwapTilesLeft());
		
		thisPuzzle.decreaseEliminateTilesLeft();
		thisPuzzle.decreaseSwapTilesLeft();
		
		assertEquals(1, thisPuzzle.getEliminateTilesLeft());
		assertEquals(1, thisPuzzle.getSwapTilesLeft());
	}

}
