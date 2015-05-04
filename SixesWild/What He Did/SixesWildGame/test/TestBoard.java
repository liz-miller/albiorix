import SixesWildGame.model.*;
import junit.framework.TestCase;

/**
 * TestBoard is the test class for testing all Board objects. This will test the Board/Square relationship,
 * but will not touch on the Board/Level relationship.
 */
public class TestBoard extends TestCase{
	
	Board thisBoard;
	Level parent;
	
	//create a basic board.  Level/Board relationship is tested in LevelTest
	public void setUp(){
		int[] vals = {1,2,3};
		int[] vals2 = {1,2,3,4,5,6};
		parent = new Puzzle(5, vals, vals2, vals, 1, 2, 3);
		thisBoard  = new Board(parent);
		
	}
	
	 public void tearDown(){
		
	}
	 
	 
	 public void testBoardConstruction(){
		 assertEquals(parent, thisBoard.getParent());
		 
		 assertEquals(0, thisBoard.countSwiped());
	 }
	 
	 public void testBoardSquares(){
		 Square square = new Square (5,4);
		 
		 thisBoard.setSquare(square);
		 
		 assertTrue(thisBoard.getSquare(square.getRow(), square.getCol()).equals(square));
		 
		 assertEquals(null, thisBoard.getTile(square.getRow(), square.getCol()));
	 }
	 
	 public void testBoardSelectedTiles(){
		 Tile tile1 = new Tile(1, 2, new Square(1,2));
		 Tile tile2 = new Tile(3, 2, new Square(2,3));
		 
		 thisBoard.pushToSelected(tile1);
		 
		 assertEquals(1, thisBoard.countSwiped());
		 assertTrue(tile1.equals(thisBoard.peekAtSelected()));
		 
		 thisBoard.pushToSelected(tile2);
		 
		 assertEquals(2, thisBoard.numSwiped());
		 assertEquals(4, thisBoard.countSwiped());
		 assertTrue(tile2.equals(thisBoard.peekAtSelected()));
		 
		 thisBoard.pushToSelected(tile1);
		 
		 assertEquals(2, thisBoard.numSwiped());
		 assertEquals(4, thisBoard.countSwiped());
		 assertTrue(tile2.equals(thisBoard.peekAtSelected()));
		 
		 assertTrue(tile2.equals(thisBoard.popFromSelected()));
		 assertEquals(1, thisBoard.numSwiped());
		 assertEquals(1, thisBoard.countSwiped());
		 
		 assertEquals(2, thisBoard.eliminateSwipedTiles()); 
		 
		 thisBoard.pushToSelected(tile1);
		 thisBoard.pushToSelected(tile2);
		 
		 assertEquals(2, thisBoard.numSwiped());
		 assertTrue(tile1.getSelected());
		 assertTrue(tile2.getSelected());
		 
		 thisBoard.remAllFromSelected();
		 
		 assertEquals(0, thisBoard.numSwiped());
		 assertFalse(tile1.getSelected());
		 assertFalse(tile2.getSelected());
	 }
	 
	 /**
	  * getAboveSquare(Square) should return the Square that is located directly above the passed in
	  * Square.
	  * TODO: this currently does not pass -- we do not know why.
	  */
	 public void testBoardGetAboveSquare(){
		 

		 
		 thisBoard.setSquare( new Square(3, 7, 4, 2));
		 thisBoard.setSquare( new Square(3, 8, 4, 2));
		 
		 assertTrue(thisBoard.getSquare(7, 3).equals(thisBoard.getAboveSquare(thisBoard.getSquare(8, 3))));
		 
		 assertFalse(thisBoard.getSquare(7, 3).equals(thisBoard.getAboveSquare(null)));
		 
		 
		 
	 }
	 
	 /**
	  * testBoardSquareMarking() - test the marking of Squares 
	  */
	 public void testBoardSquareMarking(){
		 assertFalse(thisBoard.getSquare(0, 0).isMarked());
		 assertFalse(thisBoard.getSquare(1, 1).isMarked());
		 
		 thisBoard.markAll();
		 
		 assertTrue(thisBoard.getSquare(0, 0).isMarked());
		 assertTrue(thisBoard.getSquare(1, 1).isMarked());
		 
		 thisBoard.pushToSelected(thisBoard.getSquare(0, 0).peekTile());
		 thisBoard.pushToSelected(thisBoard.getSquare(1, 1).peekTile());
		 
		 thisBoard.unMarkSwipedSquares();
		 
		 assertFalse(thisBoard.getSquare(0, 0).isMarked());
		 assertFalse(thisBoard.getSquare(1, 1).isMarked());
	 }
	 
	 public void testBoardSwapTiles(){
		 Square square1 = thisBoard.getSquare(1, 2);
		 Square square2 = thisBoard.getSquare(1, 3);
		 
		 Tile tile1 = square1.peekTile();
		 Tile tile2 = square2.peekTile();
		 
		 thisBoard.pushToSelected(tile1);
		 thisBoard.pushToSelected(tile2);
		 
		 assertTrue(square1.peekTile().equals(tile1));
		 assertTrue(square2.peekTile().equals(tile2));
		 
		 thisBoard.swapTiles();
		 
		 assertTrue(square2.peekTile().equals(tile1));
		 assertTrue(square1.peekTile().equals(tile2));
		 
	 }
	 
	 // IN PROGRESS
	 public void testBoardReset(){
		 Square square = thisBoard.getSquare(0, 0);
		 
		 assertTrue(thisBoard.getSquare(0,0).equals(square));
		 
		 thisBoard.resetBoard();
		 
	 }


}
